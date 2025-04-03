package org.engine.main;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.CameraViewer;
import org.engine.GameProperties.SpriteRenderer;
import org.engine.GameProperties.Transform;
import org.engine.Sprites.SpritePolygon;
import org.engine.Sprites.SpriteRectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Класс, в котором собраны все свойства игры, большинство из которых можно свободно менять и экспериментировать с ними.
public class GameConfig {
    public static String title = "Крутая программа на лучшем в мире движке";
    public static int windowWidth = 1000;
    public static int windowHeight = 600;
    public static Color baseWndColor = Color.black;
    public static int FPS = 60;
    public static int realFPS = FPS;
    public static final KeyHandler keyH = new KeyHandler();
    public static List<Scene> scenes = new ArrayList<>();
    public static Scene currentScene;
    public static Graphics2D graphics;
    public static Scene getSceneByID(String id){
        for(Scene s : scenes){
            if(s.sceneID.equals(id)){
                return s;
            }
        }
        throw new RuntimeException("Error: scene with ID " + id + " does not exist");
    }
    static {
        //Тут инициализируем все сцены
        String id = "Main scene";
        Scene s = new Scene(id);
        scenes.add(s);
        currentScene = scenes.getFirst();
        //--------------------
        //Камера обязательно должна иметь айди camera и быть единственной на сцене
        GameObject g = new GameObject("camera");
        g.setProperty(new Transform(g, 0, 0));
        g.setProperty(new CameraViewer(g, id, Color.darkGray, GameConfig.windowWidth / 2, GameConfig.windowHeight / 2));
        getSceneByID(id).addGameObject(g);
        //--------------------
        g = new GameObject("1");
        g.setProperty(new Transform(g, 300, 200));
        g.setProperty(new SpriteRenderer(g, new SpritePolygon(g, new Color(127, 0, 0), new Point(0, 0), new Point(30, -200), new Point(150, -45))));
        getSceneByID(id).addGameObject(g);
        //--------------------
        g = new GameObject("2");
        g.setProperty(new Transform(g, -200, 100));
        g.setProperty(new SpriteRenderer(g, new SpritePolygon(g, new Color(0, 127, 0), new Point(0, 0), new Point(100, -30), new Point(45, -45))));
        getSceneByID(id).addGameObject(g);
        //--------------------
        g = new GameObject("3");
        g.setProperty(new Transform(g, 20, -10));
        g.setProperty(new SpriteRenderer(g, new SpriteRectangle(g, new Color(127, 0, 127), 0, 0, 200, 200)));
        getSceneByID(id).addGameObject(g);
    }
}