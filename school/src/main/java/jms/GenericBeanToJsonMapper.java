package jms;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class GenericBeanToJsonMapper<T> {

    private String path;
    private T t;
    private ObjectMapper mapper;
    private Class clazz;

    public static ObjectMapper createDefaultObjectMapper() {
        return new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public GenericBeanToJsonMapper(String path, T t) {
        this.path = path;
        this.t = t;
        clazz = t.getClass();
        mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
