package ru.blogspot.feomatr.lab.jaxb;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Сервис по маршалингу\анмаршалингу объектов с использованием JAXB.
 * tested
 *
 * @author iipolovinkin
 * @since 16.08.2015
 */
public class ImportExportService {
    private static final Logger log = LoggerFactory.getLogger(ImportExportService.class);

    public List<Item> readListFromFile(File file) {
        List<Item> result = Lists.newArrayList();

        return result;
    }

    public Item readItemFromFile(File file) {
        Item result = new Item();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            result = (Item) unmarshaller.unmarshal(file);

            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("fail!");
        return null;
    }

    public Foo readMapFromFile(File file) {
        Foo result = new Foo();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Foo.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            result = (Foo) unmarshaller.unmarshal(file);

            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("fail!");
        return null;
    }

    public MyHashMapType readClearMapFromFile(File file) {
        MyHashMapType result = new MyHashMapType();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(MyHashMapType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            result = (MyHashMapType) unmarshaller.unmarshal(file);

            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("fail!");
        return null;
    }
}
