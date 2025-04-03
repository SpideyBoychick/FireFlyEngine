package org.engine.GameProperties;

import org.engine.GameObjects.GameObject;
import org.engine.main.GameConfig;
import org.engine.main.Scene;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class CameraViewer extends Property{
    public Rectangle cameraArea = new Rectangle();
    public Color BGColor;
    private Scene scene;

    public CameraViewer(GameObject gameObjectParent, String sceneID, Color bgcolor, double radiusX, double radiusY) {
        super(gameObjectParent, "CameraViewer");
        this.scene = GameConfig.getSceneByID(sceneID);
        this.BGColor = bgcolor;
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        cameraArea.x = (int)(t.x - radiusX);
        cameraArea.y = (int)(t.y - radiusY);
        cameraArea.width = (int)(2 * radiusX);
        cameraArea.height = (int)(2 * radiusY);
    }

    public void draw(){
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        GameConfig.baseWndColor = BGColor;
        AffineTransform at = new AffineTransform();
        at.translate(t.x + cameraArea.width/2, cameraArea.height/2 - t.y);
        GameConfig.graphics.setTransform(at);
        for(GameObject g : scene.gameObjects){
            if(g.containsProperty("SpriteRenderer")) {
                ((SpriteRenderer) g.getProperty("SpriteRenderer")).draw(gameObjectParent);
            }
        }
    }
}
