package jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import java.util.Map;
import java.util.function.Function;

@Service("jmsHelperService")
public class JmsHelperServiceImpl {
    private static final Logger LOG = LoggerFactory.getLogger(JmsHelperServiceImpl.class);

//    @Inject
    private ConnectionFactory connectionFactory;

    private abstract class CommonMessage<T, R extends Message> implements Function<T, R> {
        protected Session session;

        public void setSession(Session session) {
            this.session = session;
        }

        public Session getSession() {
            return session;
        }
    }

    private class MyTextMessage<T, R extends TextMessage> extends CommonMessage<T, TextMessage> {
        @Override
        public TextMessage apply(T t) {
            try {
                return session.createTextMessage(GenericBeanToJsonMapper.createDefaultObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL).writerWithDefaultPrettyPrinter().writeValueAsString(t));
            } catch (JMSException | JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class MyMapMessage<T extends Map<String, String>, R extends MapMessage> extends CommonMessage<T, MapMessage> {
        @Override
        public MapMessage apply(T map) {

            try {
                MapMessage mapMessage = session.createMapMessage();
                map.forEach((key, value) -> {
                    try {
                        mapMessage.setString(key, value);
                    } catch (JMSException e) {
                        LOG.warn(String.format("Couldn't setup message parameter: key=%s, value=%s", key, value), e);
                    }
                });

                return mapMessage;
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Message sendMapSync(String chanel, Map<String, Object> docParam, long timeout) {
        CommonMessage<Map<String, Object>, Message> commonMessage = new MyMapMessage();
        return sendMessage(chanel, docParam, commonMessage, timeout);
    }


    public <T> Message sendMessage(String chanel, T param, CommonMessage<T, Message> messageCreator, long timeout) {
        try {
            Connection connection = connectionFactory.createConnection();
            try {
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Queue queue = session.createQueue(chanel);
                TemporaryQueue temporaryQueue = session.createTemporaryQueue();
                messageCreator.setSession(session);
                Message message = messageCreator.apply(param);
                message.setJMSReplyTo(temporaryQueue);
                MessageProducer producer = session.createProducer(queue);
                message.setJMSCorrelationID(message.getJMSMessageID());
                MessageConsumer consumer = session.createConsumer(temporaryQueue);
                producer.send(message);

                return consumer.receive(timeout);
            } finally {
                connection.close();
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public Message sendMapSync(String chanel, Map<String, Object> docParam) {
        CommonMessage<Map<String, Object>, Message> commonMessage = new MyTextMessage();
        return sendMessage(chanel, docParam, commonMessage);
    }


    public <T> Message sendMessage(String chanel, T param, CommonMessage<T, Message> messageCreator) {
        return sendMessage(chanel, param, messageCreator, 60000);
    }
}
