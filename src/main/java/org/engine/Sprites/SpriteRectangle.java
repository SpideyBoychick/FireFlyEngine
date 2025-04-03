package org.engine.Sprites;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.CameraViewer;
import org.engine.GameProperties.Transform;
import org.engine.main.GameConfig;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteRectangle extends Sprite{

    Rectangle rect = new Rectangle();
    public BufferedImage image;

    public SpriteRectangle(GameObject gameObjectParent, Color color, int x, int y, int width, int height){
        super(gameObjectParent, color);
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        rect.x = (int)(t.x - x);
        rect.y = (int)(y - t.y);
        rect.width = (int)(width * t.scaleX);
        rect.height = (int)(height * t.scaleY);
    }

    public SpriteRectangle(GameObject gameObjectParent, Color color, BufferedImage image, int x, int y, int width, int height){
        super(gameObjectParent, color);
        this.image = image;
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        rect.x = (int)(t.x - x);
        rect.y = (int)(y - t.y);
        rect.width = (int)(width * t.scaleX);
        rect.height = (int)(height * t.scaleY);
    }

    public void drawSprite(GameObject camera){
        super.drawSprite(camera);
        CameraViewer cv = (CameraViewer)camera.getProperty("CameraViewer");
        if(cv.cameraArea.intersects(rect)) {
            GameConfig.graphics.setColor(color);
            GameConfig.graphics.fillRect(rect.x, rect.y, rect.width, rect.height);
            if (image != null{
                GameConfig.graphics.drawImage(image, rect.x, rect.y, rect.width, rect.height, null);
            }
        }
    }
}