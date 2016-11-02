package ru.blogspot.feomatr.lab.words.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * TODO: comment
 *
 * @author iipolovinkin
 * @since 13.03.2016
 */
public class ResolverModelImpl implements ResolverModel {
	private static final Logger log = LoggerFactory.getLogger(ResolverModelImpl.class);
	private Set<ActionListener> listeners = new HashSet();
	private List<String> words = new ArrayList<>();
	private int index = -1;
	private Map<String, String> map = new HashMap<>();


	@Override
	public void addListener(ActionListener l) {
		if (l != null) {
			listeners.add(l);
		}
	}

	@Override
	public void start() {
		index = 0;
		publishCurrentWord();
	}

	@Override
	public void finish() {
		index = -1;
		publishCurrentWord();
	}

	@Override
	public void markCurrentWord(String key) {
		String word = getCurrentWord();
		if (word == null) {
			return;
		}
		if ("1".equals(key) || "2".equals(key)) {
			map.put(word, key);

			index++;
			publishCurrentWord();
		}
	}

	@Override
	public Map<String, String> getMap() {
		return map;
	}

	public List<String> getWords() {
		return words;
	}

	@Override
	public void setWords(List<String> words) {
		this.words = words;
	}

	private void publishCurrentWord() {
		String s = null;
		String cmd;
		if (index > -1 && index < words.size()) {
			s = words.get(index);
			cmd = "update";
		} else {
			cmd = "map";
		}
		ActionEvent event = new ActionEvent(this, index, cmd);
		for (ActionListener listener : listeners) {
			listener.actionPerformed(event);
		}

	}

	@Override
	public String getCurrentWord() {
		if (index > -1 && words != null && words.size() > index) {
			return words.get(index);
		}
		return null;
	}
}
