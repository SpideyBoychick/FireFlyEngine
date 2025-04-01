package org.engine.GameObjects;
import org.engine.GameProperties.Property;

import java.util.ArrayList;
import java.util.List;


/*Игровой объект - сущность, которой описываются все объекты в игре, и имеющая различные свойства (properties),
а также уникальный номер (id)*/
public class GameObject {
    private List<Property> properties = new ArrayList<>();
    public String id;

    public GameObject(String id){
        this.id = id;
    }

    public Property getProperty(String name){
        if(containsProperty(name)) {
            for(Property p : properties){
                if(p.name.equals(name)){
                    return p;
                }
            }
        }
        throw new RuntimeException("Error: cannot get property " + name + " because object have not this property");
    }

    public boolean containsProperty(String name){
        for(Property p : properties){
            if(p.name.equals(name)){
                return true;
            }
        }
        return false;
    }

    public void setProperty(Property property){
        if(!containsProperty(property.name)){
            properties.add(property);
        }
        else{
            throw new RuntimeException("Error: property with name " + property.name + " already existed!");
        }
    }
}