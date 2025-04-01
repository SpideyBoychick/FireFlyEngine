package org.engine.Sprites;

import org.engine.GameObjects.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

//Очев
public abstract class Sprite {
    public Color color;
    BufferedImage sprite;
    GameObject gameObjectParent;

    public Sprite(GameObject gameObjectParent){
        this.gameObjectParent = gameObjectParent;
    }

    public void drawSprite(GameObject camera){

    }
}
