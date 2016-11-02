package ru.blogspot.feomatr.lab.words;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.words.model.ResolverModel;
import ru.blogspot.feomatr.lab.words.model.ResolverModelImpl;

import javax.swing.*;
import java.io.IOException;

/**
 * @author iipolovinkin
 * @since 12.03.2016
 */
public class RunSelectWord {
	private static final Logger log = LoggerFactory.getLogger(RunSelectWord.class);

	public static void main(String[] args) {
		// Start all Swing applications on the EDT.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SelectWord selectWord = new SelectWord();
				ResolverModel model = new ResolverModelImpl();
				try {
					model.setWords(Utils.fileToList(Utils.FILE_NAME + Utils.EXT));
				} catch (IOException e) {
					log.error("", e);

				}
				model.addListener(selectWord);
				selectWord.setModel(model);
				selectWord.setVisible(true);
			}
		});
	}
}
