package ru.blogspot.feomatr.lab.formats.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.jaxb.Item;
import ru.blogspot.feomatr.lab.xstream.Employee;

import java.io.*;

/**
 * @author iipolovinkin
 * @since 24.10.2015
 */
public class JacksonDemo {
	private static final Logger log = LoggerFactory.getLogger(JacksonDemo.class);

	public static void main(String[] args) {

		saveToJson();


	}

	public static void saveToJson() {
		Employee jim = new Employee("Jim", "Smith", 25, new String[]{"fatboy", "stranger", "eagle"});
		Item item = new Item(1L, "first item");
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("jim.json");

		try {
			mapper.writeValue(file, jim);
		} catch (IOException e) {
			log.error("", e);
		}

		File file2 = new File("jim.json");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
			String s = bufferedReader.readLine();
			System.out.println("jim json = " + s);
		} catch (IOException e) {
			log.error("", e);

		}
	}

}
