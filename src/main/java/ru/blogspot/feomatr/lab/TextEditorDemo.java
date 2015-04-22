package ru.blogspot.feomatr.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.*;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;

import java.awt.*;

/**
 * @author polovinkin.igor 22.04.2015 16:38
 */
public class TextEditorDemo extends JFrame {
	private static final Logger log = LoggerFactory.getLogger(TextEditorDemo.class);
	public TextEditorDemo() {

		JPanel cp = new JPanel(new BorderLayout());

		RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
		textArea.setCodeFoldingEnabled(true);
		RTextScrollPane sp = new RTextScrollPane(textArea);
		cp.add(sp);

		setContentPane(cp);
		setTitle("Text Editor Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		// Start all Swing applications on the EDT.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TextEditorDemo().setVisible(true);
			}
		});
	}
}
