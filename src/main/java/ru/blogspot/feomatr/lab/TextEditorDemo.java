package ru.blogspot.feomatr.lab;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

/**
 * @author polovinkin.igor 22.04.2015 16:38
 */
public class TextEditorDemo extends JFrame {
    private static final Logger log = LoggerFactory.getLogger(TextEditorDemo.class);

    public TextEditorDemo() {

        JPanel cp = new JPanel(new BorderLayout());
        JToggleButton copyText = new JToggleButton("copyText");
        copyText.setSize(30, 30);
        JToggleButton pasteText = new JToggleButton("pasteText");
        pasteText.setSize(30, 30);
        JToolBar jToolBar = new JToolBar();
        jToolBar.add(copyText);
        jToolBar.add(pasteText);
        jToolBar.setVisible(true);
        cp.setLayout(new BorderLayout());
        cp.add("North", jToolBar);

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);

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

        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        textArea.setCodeFoldingEnabled(true);
        File file = new File("pom.xml");
        try {
            textArea.setText(FileUtils.readFileToString(file));
        } catch (IOException e) {
            log.error("", e);

        }
//        textArea.setEditable(false);
        RTextScrollPane sp = new RTextScrollPane(textArea);
        cp.add("Center", sp);

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
