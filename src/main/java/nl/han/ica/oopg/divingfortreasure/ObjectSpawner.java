package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;
import java.util.Random;

public class ObjectSpawner implements IAlarmListener {

    private int respawnTime;
    private DivingForTreasure world;
    private Random random;
    private boolean stopAlarm;

    public ObjectSpawner(DivingForTreasure world, int respawnTime){
        this.world = world;
        this.random = new Random();
        this.respawnTime = respawnTime;
        this.stopAlarm = false;
        startAlarm();
    }

    private void spawnObjects(){
        int randomNumber;
        randomNumber = random.nextInt(10);

        if(randomNumber % 2 == 0){
            Coin coin = new Coin(world);
            world.addGameObject(coin, random.nextInt(world.getWidth() - (int) coin.getWidth()),
                    world.getHeight() - coin.getHeight());
        } else if (randomNumber == 1 || randomNumber == 3 || randomNumber == 7){
            Bomb bomb = new Bomb(world);
            world.addGameObject(bomb, random.nextInt(world.getWidth() - (int) bomb.getWidth()),
                    world.getHeight() - bomb.getHeight());
        } else if (randomNumber == 5 || randomNumber == 9){
            OxygenTank oxygenTank = new OxygenTank(world);
            world.addGameObject(oxygenTank, random.nextInt(world.getWidth() - (int) oxygenTank.getWidth()),
                    world.getHeight() - oxygenTank.getHeight());
        }
    }

    public void startAlarm() {
        Alarm alarm = new Alarm("New Object", respawnTime);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        spawnObjects();
        startAlarm();
    }

    public void setStopAlarm(boolean stopAlarm) {
        this.stopAlarm = stopAlarm;
    }
}
