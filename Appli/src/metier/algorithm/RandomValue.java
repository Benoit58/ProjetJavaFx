package metier.algorithm;

import metier.Sensor;
import metier.SensorThread;

import java.util.Random;

public class RandomValue implements IAlgorithmStrategy {

    Sensor sensor;

    public RandomValue(Sensor sensor){ this.sensor = sensor; }

    public long getFrequency(){
        return sensor.getFrequency();
    }

    //Math.random --> value in [0, 1[
    public int algorithm(){
        Random rand = new Random();
        return rand.nextInt(50) + 1;
    }
}
