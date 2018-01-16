package business_logic.algorithm;

import business_logic.sensor.ISensor;

import java.util.Random;

/**
 * Business class : random value algorithm
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class RandomValue implements IAlgorithmStrategy {

    ISensor sensor;

    /**
     * Constructor
     *
     * @param sensor
     */
    public RandomValue(ISensor sensor){ this.sensor = sensor; }

    /**
     * generate random temperature
     *
     * @return int: temperature
     */
    public int algorithm(){
        Random rand = new Random();
        return rand.nextInt(50) + 1;
    }
}
