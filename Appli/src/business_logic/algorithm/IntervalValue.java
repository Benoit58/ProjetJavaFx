package business_logic.algorithm;

import business_logic.sensor.ISensor;

/**
 * Business class : intervalValue algorithm
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class IntervalValue implements IAlgorithmStrategy {

    ISensor sensor;

    /**
     * Constructor
     *
     * @param sensor
     */
    public IntervalValue(ISensor sensor){
        this.sensor = sensor;
    }

    /**
     *
     * @return
     */
    public int algorithm(){
        int min=14, max=21;
        return (min + (int) (Math.random() * ((1 + max) - min)));
    }
}
