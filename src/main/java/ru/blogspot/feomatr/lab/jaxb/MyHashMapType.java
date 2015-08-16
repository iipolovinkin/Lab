package ru.blogspot.feomatr.lab.jaxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

/**
 * @author iipolovinkin
 * @since 16.08.2015
 */
public class MyHashMapType {
    private static final Logger log = LoggerFactory.getLogger(MyHashMapType.class);
    private List<MyHashMapEntryType> entry;

    public List<MyHashMapEntryType> getEntry() {
        return entry;
    }

    @XmlElement
    public void setEntry(List<MyHashMapEntryType> entry) {
        this.entry = entry;
    }

    public static class MyHashMapEntryType {

        private Integer key;
        private String value;

        public MyHashMapEntryType() {
        }

        public MyHashMapEntryType(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "MyHashMapEntryType{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }

        public Integer getKey() {
            return key;
        }

        @XmlAttribute
        public void setKey(Integer key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        @XmlValue
        public void setValue(String value) {
            this.value = value;
        }
    }
}
