package ru.blogspot.feomatr.lab.formats.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.xstream.Employee;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author iipolovinkin
 * @since 24.10.2015
 */
public class JacksonDemo {
	private static final Logger log = LoggerFactory.getLogger(JacksonDemo.class);
	private static List<Employee> employees;

	public static void main(String[] args) {

		init();

		String jsonWithDefaultTyping = saveToJson();
		System.out.println("jsonWithDefaultTyping from ArrayList<Employee>:\n" + jsonWithDefaultTyping);
		readFromJson(jsonWithDefaultTyping);
		System.out.println();

		String json = saveToJson2();
		System.out.println("json from ArrayList<Employee>:\n" + json);
		readFromJsonWithConstructCollectionType(json);

	}

	private static void init() {
		employees = new ArrayList<Employee>();
		employees.add(new Employee("Jim", "Smith", 25, new String[]{"fatboy", "stranger", "eagle"}));
		employees.add(new Employee("Jane", "Smith", 18, new String[]{"thingirl", "stranger", "crow"}));
		employees.add(new Employee("Ivan", "Sidorov", 25, new String[]{"fatboy", "stranger", "Turkey"}));
		employees.add(new Employee("Nikolay", "Sidorov", 65, new String[]{"thinboy", "stranger", "Woodpecker"}));
		employees.add(new Employee("Dmitriy", "Vostok", 35, new String[]{"fatboy", "stranger", "Rawen"}));
	}

	public static String saveToJson() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			Writer w = new StringWriter();
			mapper
					.enableDefaultTyping() // parser should write Class name
					.writeValue(w, employees);
			return w.toString();
		} catch (IOException e) {
			log.error("", e);
			return "";
		}
	}

	public static void readFromJson(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Employee> employesFromFile =
					mapper.enableDefaultTyping() // parser should read Class name
							.readValue(jsonString, ArrayList.class);

			Preconditions.checkArgument(CollectionUtils.isEqualCollection(employesFromFile, employees));

		} catch (IOException e) {
			log.error("", e);
		}
	}

	public static String saveToJson2() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Writer w = new StringWriter();
			mapper
					.writeValue(w, employees);
			return w.toString();
		} catch (IOException e) {
			log.error("", e);
			return "";
		}
	}

	public static void readFromJsonWithConstructCollectionType(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Employee> employesFromFile = mapper.readValue(
					jsonString,
					mapper.getTypeFactory().constructCollectionType(
							List.class, Employee.class));

			Preconditions.checkArgument(CollectionUtils.isEqualCollection(employesFromFile, employees));

		} catch (IOException e) {
			log.error("", e);
		}
	}

}
