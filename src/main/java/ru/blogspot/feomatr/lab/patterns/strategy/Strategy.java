package ru.blogspot.feomatr.lab.patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Реализация обертки над методом
 *
 * @author iipolovinkin
 * @since 28.07.2016
 */
public class Strategy {
	private static final Logger log = LoggerFactory.getLogger(Strategy.class);
	private List<String> list = new ArrayList<>(Arrays.asList("N1", "N2", "N3", "N4"));
	private String currentNode = "N5";

	public static void main(String[] args) {
		Strategy strategy = new Strategy();

		String result = strategy.getSome(new NodeCallable<String>() {
			@Override
			public String call(String node) throws Exception {
				return null;
			}
		});
		if (result != null) {
			System.out.println("result = " + result);
			return;
		}

		System.out.println("local request");

	}

	/**
	 * Метод производит попытки по выполнению запроса на нодах из list.
	 * Если найдена нода, совпадающая с текущей,
	 * тогда возвращается null и запрос следует обработать локально
	 *
	 * @param callable
	 * @param <T>
	 * @return
	 */

	public <T> T getSome(NodeCallable<T> callable) {
		boolean masterNotFound = true;
		for (String s : list) {
			if (s.equals(currentNode)) {
				masterNotFound = false;
				break;
			}
			try {
				T call = callable.call(s);
			} catch (Exception e) {

			}
		}

		if (masterNotFound) {
			throw new RuntimeException("masterNotFound");
		}

		return null;
	}

}
