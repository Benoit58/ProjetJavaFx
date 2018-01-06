package metier.algorithm;

import metier.sensor.ISensors;

public class IntervalValue implements IAlgorithmStrategy {

    ISensors sensor;

    public IntervalValue(ISensors sensor){
        this.sensor = sensor;
    }

    public long getFrequency(){
        return sensor.getFrequency();
    }

    //Math.random --> value in [0, 1[
    public int algorithm(){
        int min=14, max=21;
        return (min + (int) (Math.random() * ((1 + max) - min)));
    }
}
