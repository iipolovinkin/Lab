package ru.blogspot.feomatr.lab.serialization.jaxb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author iipolovinkin
 * @since 16.08.2015
 */
public class MyHashMapAdapter extends XmlAdapter<MyHashMapType, HashMap> {
    private static final Logger log = LoggerFactory.getLogger(MyHashMapAdapter.class);

    @Override
    public HashMap unmarshal(MyHashMapType v) throws Exception {
        HashMap m = new HashMap();
        for (MyHashMapType.MyHashMapEntryType entry : v.getEntry()) {
            m.put(entry.getKey(), entry.getValue());
        }
        return m;
    }

    @Override
    public MyHashMapType marshal(HashMap v) throws Exception {
        MyHashMapType m = new MyHashMapType();
        Set<MyHashMapType.MyHashMapEntryType> entries = new HashSet<>();
        Set<Map.Entry> set = v.entrySet();
        System.out.println("hello mars");
        for (Map.Entry entry : set) {
//            MyHashMapType.MyHashMapEntryType e = new MyHashMapType.MyHashMapEntryType(entry.getKey(), entry.getValue());
//            boolean add = entries.add(e);
        }
        m.setEntry(entries);
        return m;
    }
}
