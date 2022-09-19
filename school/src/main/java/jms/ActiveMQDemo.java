package jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

public class ActiveMQDemo {
    private static final String TEMPLATE_CODE = "TEMPLATE_CODE";
    private final JmsHelperServiceImpl jmsHelperService = new JmsHelperServiceImpl();

    public static void main(String[] args) {
        String[] templateCodes = new String[]{"TEMPLATE_CONTRACT_DU6", "TEMPLATE_CONTRACT_DU_AK"};

        sendMessage(templateCodes);
    }

    @SneakyThrows
    public static void sendMessage(String[] templateCodes) {
        final ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        final Connection connection = connectionFactory.createConnection();
        connection.start();
        final Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        final Queue queue = session.createQueue("alfaedo.document.generator.test");
        final MessageProducer producer = session.createProducer(queue);


        while (true) {
            for (String templateCode : templateCodes) {
                TextMessage message = session.createTextMessage(templateCode);
                producer.send(message);
            }
            Thread.sleep(8000);
        }


    }


    private static TextMessage createMessage(Session session, Object t) throws JsonProcessingException {
        try {
            return session.createTextMessage(GenericBeanToJsonMapper.createDefaultObjectMapper().enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL).writerWithDefaultPrettyPrinter().writeValueAsString(t));
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main2(String[] args) {
//        alfaedo.document.generator.request.chanel=alfaedo.document.generator.request.test
//        alfaedo.document.generator.contract.chanel=alfaedo.document.generator.contract.test
//        alfaedo.document.generator.contract.document.chanel=alfaedo.document.generator.contract.document.test
//        alfaedo.document.generator.chanel=alfaedo.document.generator.test
    }

    public InputStream generate(String templateCode, Map<String, Object> context) {
        try {
            context.put(TEMPLATE_CODE, templateCode);
            String documentChannel = "alfaedo.document.generator.test";
            BytesMessage message = (BytesMessage) jmsHelperService.sendMapSync(documentChannel, context);
            byte[] buffer = new byte[(int) message.getBodyLength()];
            message.readBytes(buffer);
            return new ByteArrayInputStream(buffer);
        } catch (Exception ex) {

            throw new RuntimeException("HUMANIZE_MESSAGE", ex);
        }
    }
}
