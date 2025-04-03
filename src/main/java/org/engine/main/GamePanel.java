package org.engine.main;

import javax.swing.*;
import java.awt.*;

// Класс для запуска и первичных настроек окна. Также он занимается его обновлением.
public class GamePanel extends JPanel implements Runnable{
    Thread gameThread;

    public GamePanel(){
        setPreferredSize(new Dimension(GameConfig.windowWidth, GameConfig.windowHeight));
        setBackground(GameConfig.baseWndColor);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(GameConfig.keyH);
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000 / GameConfig.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int repaints = 0;

        while(true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if(delta >= 1) {
                repaint();
                delta--;
                repaints++;
            }
            if(timer >= 1_000_000_000){
                timer = 0;
                GameConfig.realFPS = repaints;
                repaints = 0;
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        GameConfig.graphics = (Graphics2D)g;
        GameConfig.currentScene.update();
    }
}
