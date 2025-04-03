package org.editor.main;

import org.engine.main.KeyHandler;
import org.engine.main.MouseHandler;

import java.awt.*;

public class EditorConfig {
    public static String title = "Супер пупер крутой движок ееее";
    public static int FPS = 60;
    public static int realFPS = FPS;
    public static int screenWidth = 1800;
    public static int screenHeight = 1000;
    public static Color baseWndColor = new Color(200, 200, 200);
    public static KeyHandler keyH = new KeyHandler();
    public static MouseHandler mouseH = new MouseHandler();
    public static Graphics2D graphics;
}
