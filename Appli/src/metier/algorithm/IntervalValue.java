package metier.algorithm;

import metier.Sensor;
import metier.SensorThread;

public class IntervalValue implements IAlgorithmStrategy {

    Sensor sensor;

    public IntervalValue(Sensor sensor){
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
