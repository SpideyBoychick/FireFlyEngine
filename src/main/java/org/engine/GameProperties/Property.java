package org.engine.GameProperties;

import org.engine.GameObjects.GameObject;

// Базовый класс для всех свойств.
public abstract class Property {
    public String name;
    public GameObject gameObjectParent;

    public Property(GameObject gameObjectParent, String name){
        this.gameObjectParent = gameObjectParent;
        this.name = name;
    }
}