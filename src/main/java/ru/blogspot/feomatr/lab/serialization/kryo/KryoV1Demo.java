package ru.blogspot.feomatr.lab.serialization.kryo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * TODO: comment
 * <p>
 * https://code.google.com/p/kryo/wiki/V1Documentationr
 *
 * @author iipolovinkin
 * @since 04.06.2015
 */
public class KryoV1Demo {
    private static final Logger log = LoggerFactory.getLogger(KryoV1Demo.class);

    public static void main(String[] args) {
        KryoV1 kryo = new KryoV1();
//        do not need register Integer.class. Class is registered by defaul.
//        kryo.register(Integer.class);
        Integer I = new Integer(100);
        ByteBuffer buffer = ByteBuffer.allocate(256);
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        kryo.writeObject(buffer, I);
        buffer.flip();

        Integer o = kryo.readObject(buffer, Integer.class);
        System.out.println("o = " + o);
    }
}
