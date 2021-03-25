package nl.han.ica.oopg.divingfortreasure;

public class StartButton extends Button{
    private DivingForTreasure world;

    StartButton(DivingForTreasure world, int x, int y, int width, int height){
        super(x, y, width, height, "Start Game");
        this.world = world;
    }

    @Override
    public void action(){
        world.startGame();
        world.deleteGameObject(this);
    }


}
