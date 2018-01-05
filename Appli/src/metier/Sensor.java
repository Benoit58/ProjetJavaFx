package metier;

import javafx.beans.property.*;
import metier.algorithm.IAlgorithmStrategy;

public class Sensor implements ISensors{

    private SensorThread thread;

    public Sensor(){
        setSensorName("default");
        setTemperature(0);
        setFrequency(1);
    }

    public Sensor(String sensorName, int temp, int frequency){
        setSensorName(sensorName);
        setTemperature(temp);
        setFrequency(frequency);
    }

    private final StringProperty sensorName = new SimpleStringProperty();
    @Override public StringProperty sensorNameProperty() { return sensorName; }

    private final IntegerProperty temp = new SimpleIntegerProperty();
    @Override public IntegerProperty temperatureProperty(){return temp;}

    private final IntegerProperty frequency = new SimpleIntegerProperty();
    @Override public IntegerProperty frequencyProperty(){return frequency;}

    public void startSensorThread(IAlgorithmStrategy generator){
        this.setTemperature(generator.algorithm());
        thread = new SensorThread(this, generator);
        this.thread.start();
    }

    public SensorThread getThread() {
        return thread;
    }

    public void stopSensorThread(){
        thread.interrupt();
        thread = null;
    }

    public String toString(){
        return  String.format("%s - temp : %d - (f : %d)", getSensorName(), getTemperature(), getFrequency());
    }

}
