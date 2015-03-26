package ru.blogspot.feomatr.lab;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Walker extends JFrame implements ActionListener {
    boolean auto = true;
    boolean go = !false;

    Timer mainTimer = new Timer(100, this);

    Image image;
    Image image2;
    BufferedImage bigImg;

    private int p_frame = 0;

    final int width = 32;
    final int height = 32;
    final int rows = 5;
    final int cols = 5;
    BufferedImage[] sprites = new BufferedImage[rows * cols];
    protected int Y;
    protected int X;
    String pathname = "walker/walker.png";

    public Walker() throws IOException {

        this.setTitle("2D Engine Test");
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);



        try {
            bigImg = ImageIO.read(new File("resources/walker.png"));
        } catch (IIOException e) {
            e.printStackTrace();

            return;
        }

        if (auto)
            mainTimer.start();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sprites[(i * cols) + j] = bigImg.getSubimage(j * width, i
                        * height, width, height);
            }
        }

        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent evt) {
                System.out.println(evt.getKeyCode());
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_Z:
                        auto = !auto;
                        if (auto)
                            mainTimer.start();
                        else {
                            mainTimer.stop();
                        }
                        break;
                    case KeyEvent.VK_X:
                        go = !go;
                        break;
                    case KeyEvent.VK_SPACE:
                        Y = 0;
                        X = 0;
                        break;
                    case KeyEvent.VK_UP:
                        Y = -1;
                        repaint();// increase speed
                        break;
                    case KeyEvent.VK_DOWN:
                        Y = 1;
                        repaint();// increase speed
                        break;
                    case KeyEvent.VK_LEFT:
                        X = -1;
                        repaint();// increase speed
                        break;
                    case KeyEvent.VK_RIGHT:
                        X = +1;
                        // p_frame = (p_frame + 1) % 4;
                        repaint();// increase speed
                        break;
                }
            }
        });
    }

    int plus = 0;
    private int plusV;

    // Image img = new ImageIcon("res\\Hero.png").getImage();
    @Override
    public void paint(Graphics g) {
        // super.paint(g);
        // g = (Graphics2D) g;
        g.clearRect(100, 150, 164, 164);
        g.drawImage(sprites[p_frame], 100, 150, 164, 164, null);

        g.clearRect(0 + plus, 50 + plusV, 64, 64);
        g.drawImage(sprites[p_frame], 0 + plus, 50 + plusV, 64, 64, null);

        g.clearRect(310, 50, 64, 64);
        g.drawImage(sprites[p_frame], 310, 50, 64, 64, null);
        g.drawImage(sprites[p_frame], 210, 50, 64, 64, null);
        if (go)
            p_frame = (p_frame + 1) % 4;
        plus += 3 * X;
        plusV += 3 * Y;
        System.out.println("update " + p_frame);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
