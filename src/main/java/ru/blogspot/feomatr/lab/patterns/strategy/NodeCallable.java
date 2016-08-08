package ru.blogspot.feomatr.lab.patterns.strategy;

/**
 * @author iipolovinkin
 * @since 28.07.2016
 */
public interface NodeCallable<T> {
	T call(String node) throws Exception;
}
