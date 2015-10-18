package ru.blogspot.feomatr.lab.jdbc;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author polovinkin.igor
 * @since 14.10.2015
 */
public class JDBCDemo {
	private static final String TABLE_NAME = "table_name";
	private static final String COLUMN_NAME = "column_name";
	private static final String UDT_NAME = "udt_name";
	private static final String CHARACTER_MAXIMUM_LENGTH = "character_maximum_length";
	private static Connection connection = null;

	private static String query = " select table_name, column_name, ordinal_position, is_nullable, \n" +
	                              " data_type, udt_name, character_maximum_length, character_octet_length, numeric_precision , numeric_precision_radix\n" +
	                              " from information_schema.columns ";


	public static void main(String[] args) {
		getColumnDefinitions(args);
	}

	public static Map<String, Map<String, String>> getColumnDefinitions(String[] args) {
		Map<String, Map<String, String>> map = new HashMap<>();
		String dbSettings = "src/main/resources/jdbc/local.properties";
		try {
			Connection connection = intializeConnection(dbSettings);
			if (connection == null) {
				System.out.println("Failed to make connection!");
				return map;
			}
			System.out.println("You made it, take control your database now!");
			map = ggg(connection);
			System.out.println("map.entrySet().size() = " + map.entrySet().size());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	private static Connection intializeConnection(String dbProperties) throws IOException, SQLException {
		Connection conn = null;
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? "
			                   + "Include in your library path!");
			e.printStackTrace();
			return conn;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Properties properties = new Properties();
		properties.load(new FileInputStream(new File(dbProperties)));
		String jdbcUrl = properties.getProperty("jdbc.url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		conn = DriverManager.getConnection(jdbcUrl, user, password);
		return conn;
	}

	public static Map<String, Map<String, String>> ggg(Connection conn) throws SQLException {
		Statement stmt = null;
		Map<String, Map<String, String>> map = new HashMap<>();
		try {
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			ResultSet rs = stmt.executeQuery(query);
			if (rs.first()) {
				Pair<String, Map<String, String>> pair = getValue(rs);
				map.put(pair.getKey(), pair.getValue());
				while (rs.next()) {
					pair = getValue(rs);
					map.put(pair.getKey(), pair.getValue());
				}
			} else {
				System.out.println("rs = is empty");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static Pair<String, Map<String, String>> getValue(ResultSet resultSet) throws SQLException {
		String table_name = resultSet.getString(TABLE_NAME);
		String column_name = resultSet.getString(COLUMN_NAME);
		String udt_name = resultSet.getString(UDT_NAME);
		String character_maximum_length = resultSet.getString(CHARACTER_MAXIMUM_LENGTH);

		String key = table_name + ";" + column_name;
		Map<String, String> value = new HashMap<>();
		value.put(TABLE_NAME, table_name);
		value.put(COLUMN_NAME, column_name);
		value.put(UDT_NAME, udt_name);
		value.put(CHARACTER_MAXIMUM_LENGTH, character_maximum_length);
		return new ImmutablePair<>(key, value);
	}
}
