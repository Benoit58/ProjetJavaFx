package business_logic.algorithm;

import business_logic.sensor.ISensor;

import java.util.Random;

public class RandomValue implements IAlgorithmStrategy {

    ISensor sensor;

    public RandomValue(ISensor sensor){ this.sensor = sensor; }

    //Math.random --> value in [0, 1[
    public int algorithm(){
        Random rand = new Random();
        return rand.nextInt(50) + 1;
    }
}
