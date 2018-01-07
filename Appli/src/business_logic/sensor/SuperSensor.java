package business_logic.sensor;

import business_logic.algorithm.IAlgorithmStrategy;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SuperSensor implements ISensor {
    private SensorThread thread;

    public SuperSensor(){
        setSensorName("default");
        setTemperature(0);
        setFrequency(1);
    }

    public SuperSensor(int id, String sensorName, ISensor sensor){
        setSensorName(sensorName);
        set(temp);
        setFrequency(frequency);
    }

    private final StringProperty sensorName = new SimpleStringProperty();
    @Override public StringProperty sensorNameProperty() { return sensorName; }

    private final IntegerProperty temp = new SimpleIntegerProperty();
    @Override public IntegerProperty temperatureProperty(){return temp;}


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
