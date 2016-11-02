package ru.blogspot.feomatr.lab.words.model;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

/**
 * TODO: comment
 *
 * @author iipolovinkin
 * @since 13.03.2016
 */
public interface ResolverModel {
	void addListener(ActionListener l);

	void start();

	void finish();

	void markCurrentWord(String key);

	Map<String, String> getMap();

	String getCurrentWord();

	void setWords(List<String> words);
}
