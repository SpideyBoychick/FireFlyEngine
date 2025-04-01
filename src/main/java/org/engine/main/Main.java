package org.engine.main;

import javax.swing.*;

/*Создание окна + точка входа, хотите добавить что-то на сцену - вам в класс Config,
а вообще надо не в комментариях инфу искать, а на гитхабе, и заодно звёздочку поставить))*/
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle(Config.title);
        window.setResizable(false);
        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.startThread();
    }
}