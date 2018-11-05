package game.main;

import java.awt.*;
import java.util.LinkedList;

//3 goto GameObject
public class Handler {

    //11
    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    //12
    //create loop threw all GameObjects
    public void tick(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);


            tempObject.tick();
        }
    }
    //13
    public void render(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);

            tempObject.render(g);
        }
    }
    //14
    public  void  addObject(GameObject object){
        this.objects.add(object);
    }

    public  void  removeObject(GameObject object){
        this.objects.remove(object);
    }
}
