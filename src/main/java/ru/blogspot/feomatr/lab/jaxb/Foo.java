package ru.blogspot.feomatr.lab.jaxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;

/**
 * Class contains HashMap for masrshaling.
 *
 * @author iipolovinkin
 * @since 16.08.2015
 */
@XmlRootElement
public class Foo {
    private static final Logger log = LoggerFactory.getLogger(Foo.class);

    private HashMap hashMap;


    public Foo() {
    }

    public Foo(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "hashMap=" + hashMap +
                '}';
    }

    @XmlJavaTypeAdapter(MyHashMapAdapter.class)
    @XmlElement
    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }
}
