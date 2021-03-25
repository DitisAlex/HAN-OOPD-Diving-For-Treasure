package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.alarm.Alarm;
import nl.han.ica.oopg.alarm.IAlarmListener;

import java.util.Random;

public class SharkSpawner implements IAlarmListener {
    private DivingForTreasure world;
    private Random random;
    private boolean stopAlarm;

    public SharkSpawner(DivingForTreasure world){
        this.world = world;
        this.random = new Random();
        this.stopAlarm = false;
        startAlarm();
    }

    public void spawnShark(){
        int minSpawnLocation = 250;
        int maxSpawnLocation = 480;

        Shark shark = new Shark(world);
        world.addGameObject(shark, 0, random.nextInt(maxSpawnLocation - minSpawnLocation) + minSpawnLocation);
    }

    public void startAlarm() {
        Alarm alarm = new Alarm("New Object", 5);
        alarm.addTarget(this);
        alarm.start();
    }

    @Override
    public void triggerAlarm(String alarmName) {
        spawnShark();
        startAlarm();
    }

    public void setStopAlarm(boolean stopAlarm) {
        this.stopAlarm = stopAlarm;
    }
}
