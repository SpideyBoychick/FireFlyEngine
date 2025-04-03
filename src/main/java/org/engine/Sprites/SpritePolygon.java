package org.engine.Sprites;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.CameraViewer;
import org.engine.GameProperties.Transform;
import org.engine.main.GameConfig;

import java.awt.*;

//Рисуем полигон
public class SpritePolygon extends Sprite {

    public Polygon polygon = new Polygon();

    public SpritePolygon(GameObject gameObjectParent, Color color, Point... localPoints){
        super(gameObjectParent, color);
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        for(Point p : localPoints){
            //Да, я в курсе что масштаб работает неправильно, и заодно перемещает объект, потом как-нибудь изменю (а может и не изменю)
            polygon.addPoint((int)((t.x + p.x) * t.scaleX), (int)((-t.y -p.y) * t.scaleY));
        }
    }

    public void drawSprite(GameObject camera){
        super.drawSprite(camera);
        CameraViewer cv = ((CameraViewer)camera.getProperty("CameraViewer"));
        if(polygon.intersects(cv.cameraArea)) {
            GameConfig.graphics.setColor(color);
            GameConfig.graphics.fillPolygon(polygon);
        }
    }
}