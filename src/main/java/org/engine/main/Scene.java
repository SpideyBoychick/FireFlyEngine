package org.engine.main;

import org.engine.GameObjects.GameObject;
import org.engine.GameProperties.CameraViewer;
import org.engine.GameProperties.SpriteRenderer;

import java.util.ArrayList;
import java.util.List;

// Сцена - набор игровых объектов, один из которых - камера.
public class Scene{

    String sceneID;

    public List<GameObject> gameObjects = new ArrayList<>();

    public Scene(String sceneID){
        this.sceneID = sceneID;
    }

    public void addGameObject(GameObject gameObject){
        for(GameObject g : gameObjects) {
            if (g.id.equals(gameObject.id)) {
                throw new RuntimeException("Error: game object with id " + gameObject.id + " already exist!");
            }
        }
        gameObjects.add(gameObject);
    }

    public GameObject getGameObject(String id){
        for(GameObject g : gameObjects) {
            if (g.id.equals(id)) {
                return g;
            }
        }
        throw new RuntimeException("Error: game object with id " + id + " does not exist!");
    }

    public void update(){
        GameObject camera = getGameObject("camera");
        CameraViewer cv = (CameraViewer)camera.getProperty("CameraViewer");
        cv.draw();
    }
}
