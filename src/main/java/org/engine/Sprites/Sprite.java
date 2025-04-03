package org.engine.Sprites;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.Transform;
import org.engine.main.GameConfig;

import java.awt.*;

//Очев
public abstract class Sprite {
    public Color color;
    GameObject gameObjectParent;

    public Sprite(GameObject gameObjectParent, Color color){
        this.gameObjectParent = gameObjectParent;
        this.color = color;
    }

    public void drawSprite(GameObject camera){
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        GameConfig.graphics.rotate(t.theta);
    }
}
