package ru.blogspot.feomatr.lab.serialization.sax;

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
import java.util.Map;

/**
 * @author iipolovinkin
 * @since 30.09.2015
 */
public class SaxParserDemo {
	private static final Logger log = LoggerFactory.getLogger(SaxParserDemo.class);
	private static final String ID = "id";
	private static final String TYPE = "type";
	private static final String LENGTH = "length";
	private static final String DESC = "desc";
	private static String table = null;
	private static String file = null;
	private SAXParser saxParser = null;
	private Map<String, Map<String, String>> tableMap = new HashMap<>();

	DefaultHandler handler = new DefaultHandler() {
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                    System.out.println(String.format("%s, %s, %s, %s", uri, localName, qName, attributes.getValue("id")));
			if ("fieldset-def".equals(qName)) {
				table = attributes.getValue("table");
			}
			if ("content".equals(qName)) {
				table = attributes.getValue("table");
			}
			if (StringUtils.isNotEmpty(table)) {
				if ("field".equals(qName)) {
					String id = attributes.getValue("id");
					String type = attributes.getValue("type");
					String length = attributes.getValue("length");
					String desc = attributes.getValue("desc");
					Map<String, String> value = new HashMap<>();
					value.put(ID, id);
					value.put(TYPE, type);
					value.put(LENGTH, length);
					value.put(DESC, desc);
					String key = StringUtils.lowerCase(table + ", " + id);
					tableMap.put(key, value);
				}
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
		}
	};


	public static void main(String[] args) {


		String descXml = "src/main/resources/jaxb/ZKR.desc";
		Map<String, Map<String, String>> map = new SaxParserDemo().getFieldDescriptions(descXml);
		for (String s : map.keySet()) {
			System.out.println(s);
			System.out.println(map.get(s));
		}
	}

	public SaxParserDemo() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			saxParser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			log.error("", e);

		} catch (SAXException e) {
			log.error("", e);

		}
	}

	public Map<String, Map<String, String>> getFieldDescriptions(String xmlFile) {
		if (saxParser == null) {
			return new HashMap<>();
		}
		try {
			saxParser.parse(xmlFile, handler);
		} catch (SAXException e) {
			log.error("", e);

		} catch (IOException e) {
			log.error("", e);

		}
		return tableMap;
	}

}
