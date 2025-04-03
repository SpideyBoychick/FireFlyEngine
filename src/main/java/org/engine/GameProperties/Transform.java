package org.engine.GameProperties;

import org.engine.GameObjects.GameObject;

//Свойство объекта, описывающее все его пространственные характеристики
public class Transform extends Property{

    public double x, y;
    public double scaleX, scaleY;
    public double theta;

    public Transform(GameObject gameObjectParent, double x, double y){
        super(gameObjectParent, "Transform");
        this.x = x;
        this.y = y;
        scaleX = 1;
        scaleY = 1;
    }

    public Transform(GameObject gameObjectParent, double x, double y, double scaleX, double scaleY){
        super(gameObjectParent, "Transform");
        this.x = x;
        this.y = y;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
    }

    public Transform(GameObject gameObjectParent, double x, double y, double scaleX, double scaleY, double theta){
        super(gameObjectParent, "Transform");
        this.x = x;
        this.y = y;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.theta = theta;
    }
}
