package ru.blogspot.feomatr.lab.guava;

import com.google.common.collect.ImmutableMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author polovinkin.igor
 * @since 17.08.2015
 */
public class ImmutableMapTest {

	private Object key1 = "k1";
	private Object key2 = "k2";
	private Object value1 = "value 1";
	private Object value2 = "value 2";

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testImmutableMapBuilder() {
		ImmutableMap<String, String> map = new ImmutableMap.Builder()
				.put(key1, value1)
				.put(key2, value2)
				.build();
		System.out.println(map);
	}
}