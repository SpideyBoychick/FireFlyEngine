package org.engine.GameProperties;

import org.engine.GameObjects.GameObject;
import org.engine.main.Config;
import org.engine.main.Scene;

import java.awt.*;

public class CameraViewer extends Property{
    public Rectangle cameraArea = new Rectangle();
    public Color BGColor;
    private Scene scene;

    public CameraViewer(GameObject gameObjectParent, String sceneID, Color bgcolor, double radiusX, double radiusY) {
        super(gameObjectParent, "CameraViewer");
        this.scene = Config.getSceneByID(sceneID);
        this.BGColor = bgcolor;
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        cameraArea.x = (int)(t.x - radiusX);
        cameraArea.y = (int)(t.y - radiusY);
        cameraArea.width = (int)(2 * radiusX);
        cameraArea.height = (int)(2 * radiusY);
    }

    public void draw(){
        Config.baseWndColor = BGColor;
        for(GameObject g : scene.gameObjects){
            if(g.containsProperty("SpriteRenderer")) {
                ((SpriteRenderer) g.getProperty("SpriteRenderer")).draw(gameObjectParent);
            }
        }
    }
}
