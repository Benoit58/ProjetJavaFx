package metier.sensor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import metier.algorithm.IAlgorithmStrategy;

public interface ISensors {

    default public String getSensorName() {return sensorNameProperty().get();}
    default public void setSensorName(String name) {this.sensorNameProperty().set(name);}

    default public int getTemperature() {return temperatureProperty().get();}
    default public void setTemperature(int temperature) {this.temperatureProperty().set(temperature);}

    default public int getFrequency() {return frequencyProperty().get();}
    default public void setFrequency(int freq) {this.frequencyProperty().set(freq);}

    public StringProperty sensorNameProperty();
    public IntegerProperty temperatureProperty();
    public IntegerProperty frequencyProperty();

    public SensorThread getThread();
    public void stopSensorThread();
    public void startSensorThread(IAlgorithmStrategy generator);

}
