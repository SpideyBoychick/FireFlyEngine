package org.engine.Sprites;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.CameraViewer;
import org.engine.GameProperties.Transform;
import org.engine.main.Config;

import java.awt.*;

//Рисуем полигон
public class SpritePolygon extends Sprite {

    public Polygon polygon = new Polygon();

    public SpritePolygon(GameObject gameObjectParent, Color color, Point... localPoints){
        super(gameObjectParent);
        this.color = color;
        Transform t = (Transform)gameObjectParent.getProperty("Transform");
        for(Point p : localPoints){
            //Да, я в курсе что масштаб работает неправильно, и заодно перемещает объект, потом как-нибудь изменю (а может и не изменю)
            polygon.addPoint((int)((t.x + p.x) * t.scaleX), (int)((-t.y -p.y) * t.scaleY));
        }
    }

    public void drawSprite(GameObject camera){
        Transform t = ((Transform)camera.getProperty("Transform"));
        CameraViewer cv = ((CameraViewer)camera.getProperty("CameraViewer"));
        for (int i = 0; i < polygon.xpoints.length; i++){
            polygon.xpoints[i] -= (int)t.x;
        }
        for (int i = 0; i < polygon.ypoints.length; i++){
            polygon.ypoints[i] += (int)t.y;
        }
        //ToDo: добавить отрисовку спрайта на полигоне (пока не ебу как, полигон это же не только треугольник, а любой н-угольник, и не факт что выпуклый)
        if(polygon.intersects(cv.cameraArea)) {
            Config.graphics.setColor(color);
            Config.graphics.fillPolygon(polygon);
            for (int i = 0; i < polygon.xpoints.length; i++){
                polygon.xpoints[i] += (int)t.x;
            }
            for (int i = 0; i < polygon.ypoints.length; i++){
                polygon.ypoints[i] -= (int)t.y;
            }
        }
    }
}