package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.Sprite;

public abstract class Object extends SpriteObject implements ICollidableWithGameObjects {
    protected DivingForTreasure world;
    private static int speed = 1;

    public Object(DivingForTreasure world, String object){
        super(new Sprite(DivingForTreasure.MEDIA_URL.concat(object)));
        this.world = world;
    }

    @Override
    public void update(){
        setDirectionSpeed(0, speed);
        if(this.y <= 0){
            this.outOfScreen(world);
        }
    }
    public void outOfScreen(DivingForTreasure world){
        world.deleteGameObject(this);
    }

    public static void setSpeed(int speed) {
        Object.speed = speed;
    }

    public abstract void action();

    public void delete(DivingForTreasure world){
        world.deleteGameObject(this);
    }
}
