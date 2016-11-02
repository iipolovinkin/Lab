package ru.blogspot.feomatr.lab.words;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.blogspot.feomatr.lab.words.model.ResolverModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author iipolovinkin
 * @since 12.03.2016
 */
public class SelectWord extends JFrame implements ActionListener {
	private static final Logger log = LoggerFactory.getLogger(SelectWord.class);
	private JLabel infoLabel = new JLabel("InfoLabel");
	private ResolverModel model;

	public SelectWord() throws HeadlessException {

//		JPanel cp = createPanel();
//		setContentPane(init());
		init();

		setTitle("Выбор слов");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(getKeyListener());
		pack();
		setLocationRelativeTo(null);
		setSize(500, 300);

	}


	void init() {
		JPanel jp = new JPanel();
		jp.setLayout(null);
//		setLayout(null);
		add(jp);
		JButton bStart = new JButton("start");
		bStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				log.info("e = ", e);
				model.start();
			}
		});
		jp.add(bStart);
		int x = 10;
		int y = 10;
		int widht = 100;
		int height = 40;

		bStart.setBounds(x, y, widht, height);


		KeyListener listener = getKeyListener();
		bStart.addKeyListener(listener);

		JButton bFinish = new JButton("finish");
		bFinish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Map<String, String> map = model.getMap();
				for (Map.Entry<String, String> entry : map.entrySet()) {
					log.info("entry = " + entry);
				}
			}
		});
		jp.add(bFinish);

		bFinish.addKeyListener(listener);
		x += widht + 10;
//		y += height + 10;

		bFinish.setBounds(x, y, widht, height);
		infoLabel.setBounds(x, y + 50, 100, 50);
		infoLabel.addKeyListener(listener);
		jp.addKeyListener(listener);
		jp.add(infoLabel);
	}

	private KeyListener getKeyListener() {
		return new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				log.info("e.getKeyChar() = " + e.getKeyChar());
				model.markCurrentWord(String.valueOf(e.getKeyChar()));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				new UnsupportedOperationException();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				new UnsupportedOperationException();
			}
		};
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if ("update".equals(cmd)) {
			String word = ((ResolverModel) e.getSource()).getCurrentWord();
			updateCurrentLabel(word);
			log.info("e = " + cmd + " " + word);
		}

		if ("map".equals(cmd)) {
			Map<String, String> map = ((ResolverModel) e.getSource()).getMap();
			TreeSet set1 = new TreeSet<>();
			TreeSet set2 = new TreeSet<>();

			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				if ("1".equals(value)) {
					set1.add(key);
					continue;
				}
				if ("2".equals(value)) {
					set2.add(key);
					continue;
				}
				log.info("entry = " + entry);
			}
			try {
				log.info("1.txt, 2.txt");
				FileUtils.writeLines(new File("1.txt"), set1);
				FileUtils.writeLines(new File("2.txt"), set2);
			} catch (IOException e1) {
				log.error("", e1);

			}

		}

	}

	private void updateCurrentLabel(String word) {
		this.infoLabel.setText(word);
	}

	public void setModel(ResolverModel model) {
		this.model = model;
	}
}
