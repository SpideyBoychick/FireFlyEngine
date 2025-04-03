package org.editor.main;

import javax.swing.*;
import java.awt.*;

public class EditorPanel extends JPanel implements Runnable {
    Thread gameThread;

    public EditorPanel() {
        setPreferredSize(new Dimension(EditorConfig.screenWidth, EditorConfig.screenHeight));
        setBackground(EditorConfig.baseWndColor);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(EditorConfig.keyH);
        addMouseListener(EditorConfig.mouseH);
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / EditorConfig.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int repaints = 0;

        while (true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (delta >= 1) {
                repaint();
                delta--;
                repaints++;
            }
            if (timer >= 1_000_000_000) {
                timer = 0;
                EditorConfig.realFPS = repaints;
                repaints = 0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        EditorConfig.graphics = (Graphics2D) g;
    }
}