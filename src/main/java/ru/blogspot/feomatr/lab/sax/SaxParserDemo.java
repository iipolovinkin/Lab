package ru.blogspot.feomatr.lab.sax;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author iipolovinkin
 * @since 30.09.2015
 */
public class SaxParserDemo {
    private static final Logger log = LoggerFactory.getLogger(SaxParserDemo.class);
    private static String table = null;
    private static String file = null;
    private static HashSet<String> tableSet = null;
    private static Map<String, HashSet<String>> map = new HashMap<>();

    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            String descXml = "src/main/resources/jaxb/ZKR.desc";
            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                    System.out.println(String.format("%s, %s, %s, %s", uri, localName, qName, attributes.getValue("id")));
                    if ("fieldset-def".equals(qName)) {
                        table = attributes.getValue("table");
                        tableSet = new HashSet<String>();
                    }
                    if ("content".equals(qName)) {
                        table = attributes.getValue("table");
                        tableSet = new HashSet<String>();
                    }
                    if (StringUtils.isNotEmpty(table)) {
                        if ("field".equals(qName)) {
                            String id = attributes.getValue("id");
                            String type = attributes.getValue("type");
                            String length = attributes.getValue("length");
                            String desc = attributes.getValue("desc");
                            tableSet.add(id + "," + type + "," + length + "," + desc);
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if ("fieldset-def".equals(qName)) {
                        map.put(file + "," + table, tableSet);
                    }
                    if ("content".equals(qName)) {
                        map.put(file + "," + table, tableSet);
                    }
                }
            };

            saxParser.parse(descXml, handler);

            System.out.println("map.keySet() = " + map.keySet());
            for (Map.Entry<String, HashSet<String>> stringHashSetEntry : map.entrySet()) {
                System.out.print("key = " + stringHashSetEntry.getKey());
                System.out.println(", fields = " + stringHashSetEntry.getValue().size());
            }

        } catch (ParserConfigurationException e) {
            log.error("", e);

        } catch (SAXException e) {
            log.error("", e);

        } catch (IOException e) {
            log.error("", e);

        }
    }
}
