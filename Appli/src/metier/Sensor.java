package metier;

import javafx.beans.property.*;
import metier.algorithm.IAlgorithmStrategy;

public class Sensor {

    SensorThread thread;

    private final StringProperty sensorName = new SimpleStringProperty();
        public String getSensorName() {return sensorName.get();}
        public void setSensorName(String name) {this.sensorName.set(name);}
        public StringProperty sensorNameProperty() { return sensorName; }

    private final IntegerProperty temp = new SimpleIntegerProperty();
        public int getTemperature() {return temp.get();}
        public void setTemperature(int temperature) {this.temp.set(temperature);}
        public IntegerProperty temperatureProperty(){return temp;}

    private final IntegerProperty frequency = new SimpleIntegerProperty();
        public long getFrequency() {return frequency.get();}
        public void setFrequency(int freq) {this.frequency.set(freq);}
        public IntegerProperty frequencyProperty(){return frequency;}

    public Sensor(String sensorName, int temp, int frequency){
        this.sensorName.set(sensorName);
        this.temp.set(temp);
        this.frequency.set(frequency);
    }

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

    @Override
    public String toString(){
        return  sensorName + " - temp : " + temp ;
    }

}
