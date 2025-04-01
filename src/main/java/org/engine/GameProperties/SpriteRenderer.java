package org.engine.GameProperties;

import org.engine.GameObjects.GameObject;
import org.engine.Sprites.Sprite;

//Свойство объекта, отвечающее за его вывод на экран
public class SpriteRenderer extends Property {
    Sprite sprite;

    public SpriteRenderer(GameObject gameObjectParent, Sprite sprite) {
        super(gameObjectParent, "SpriteRenderer");
        this.sprite = sprite;
    }

    public void draw(GameObject camera){
        sprite.drawSprite(camera);
    }
}