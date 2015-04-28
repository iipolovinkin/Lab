package ru.blogspot.feomatr.lab;

import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Vector;

import static org.fluentjava.FluentUtils.map;
import static org.fluentjava.FluentUtils.pair;

/**
 * @author polovinkin.igor 22.04.2015 16:38
 */
public class TextEditorDemo extends JFrame {
    private static final Logger log = LoggerFactory.getLogger(TextEditorDemo.class);

    public TextEditorDemo() {
        final RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        JPanel cp = new JPanel(new BorderLayout());

        JToolBar jToolBar = getToolBar(textArea);
        jToolBar.setVisible(true);

        cp.setLayout(new BorderLayout());
        cp.add("North", jToolBar);

        textArea.setDropTarget(new DropTarget() {
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    java.util.List<File> droppedFiles = (java.util.ArrayList<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file : droppedFiles) {
                        String s = FileUtils.readFileToString(file);
                        textArea.setText(s);
                        // process files
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        textArea.setCodeFoldingEnabled(true);

//        textArea.setEditable(false);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add("Center", sp);

        setContentPane(cp);
        setTitle("Text Editor Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }

    private JToolBar getToolBar(final RSyntaxTextArea textArea) {
        final Map<String, String> snippets = map(
                pair(SyntaxConstants.SYNTAX_STYLE_XML, "<root>\n\t<head>\n\t<body>\n\t</body>\n\t</head>\n</root>"),
                pair(SyntaxConstants.SYNTAX_STYLE_JAVA, "\npublic static void main(String[] args){ \n return; \n}"),
                pair(SyntaxConstants.SYNTAX_STYLE_HTML, "<html>\n<head>\nHello</head>\n<body>Text</br> is! \n</body>\n</html>"),
                pair(SyntaxConstants.SYNTAX_STYLE_SQL, "\nselect * from employee \n where id =100;"));

        JButton copyText = new JButton("copyText");
//        copyText.setSize(30, 30);
        JButton pasteText = new JButton("pasteText");
//        pasteText.setSize(30, 30);
        JButton pomButton = new JButton("pom.xml");
//        pomButton.setSize(30, 30);
        JToolBar jToolBar = new JToolBar();
        jToolBar.add(copyText);
        jToolBar.add(pasteText);
        jToolBar.add(pomButton);
        final JComboBox<String> style = new JComboBox<>();
        style.setModel(new DefaultComboBoxModel<String>(new Vector<String>(snippets.keySet())));
        style.setSize(30,40);

        style.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = (String) style.getSelectedItem();
                textArea.setSyntaxEditingStyle(key);
                textArea.setText(snippets.get(key));
            }
        });
        jToolBar.add(style);
        copyText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectionStart = textArea.getSelectionStart();
                int selectionEnd = textArea.getSelectionEnd();

                textArea.selectAll();
                textArea.copy();

                textArea.setSelectionStart(selectionStart);
                textArea.setSelectionEnd(selectionEnd);

                return;
            }
        });

        pasteText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.selectAll();
                textArea.paste();
                return;
            }
        });
        pomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("pom.xml");
                try {
                    textArea.setText(FileUtils.readFileToString(file));
                } catch (IOException ex) {
                    log.error("", ex);

                }
                return;
            }
        });
        return jToolBar;
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
