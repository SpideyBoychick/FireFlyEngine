package org.editor.main;

import javax.swing.*;

public class Main {

    public static void main(String... args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle(EditorConfig.title);
        window.setResizable(false);
        EditorPanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.startThread();
    }

}
