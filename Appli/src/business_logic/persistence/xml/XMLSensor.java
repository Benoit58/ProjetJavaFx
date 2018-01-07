package business_logic.persistence.xml;

import javafx.beans.property.*;
import business_logic.sensor.ISensor;
import business_logic.sensor.SensorThread;
import business_logic.sensor.SensorFactory;
import business_logic.algorithm.IAlgorithmStrategy;

import java.io.*;

/**
 * Business class for XML persistence management : Serializable Sensor used as a proxy to serialize ISensor
 *
 * @author Yannis Mahiou and Benoit Louveau
 */
public class XMLSensor implements ISensor, Serializable{
    /**
     * Create an XMLSensor by default
     */
    public XMLSensor(){
        this(SensorFactory.create());
    }

    /**
     * Create a XMLSensor using an ISensor
     *
     * @param model the ISensor to convert in XMLSensor
     */
    public XMLSensor(ISensor model) {
        this.model = model;
        sensorName = new SimpleStringProperty(model.getSensorName());
        temp = new SimpleIntegerProperty(model.getTemperature());
        frequency = new SimpleIntegerProperty(model.getFrequency());
    }


    private transient ISensor model;

    /**
     * Get the ISensor who corresponds to the XMLSensor
     *
     * @return the ISensor as model to create the XMLSensor
     */
    public ISensor getModel() {
        return model;
    }

    private final StringProperty sensorName;
        @Override public StringProperty sensorNameProperty() {return model.sensorNameProperty();}
        @Override public  String getSensorName() {return ISensor.super.getSensorName();}
        @Override public void setSensorName(String name) {ISensor.super.setSensorName(name);}

    private final IntegerProperty temp;
        @Override public IntegerProperty temperatureProperty() {return model.temperatureProperty();}
        @Override public int getTemperature() {return ISensor.super.getTemperature();}
        @Override public void setTemperature(int temp) {ISensor.super.setTemperature(temp);}

    private final IntegerProperty frequency;
        @Override public IntegerProperty frequencyProperty() {return model.frequencyProperty();}
        @Override public int getFrequency() {return ISensor.super.getFrequency();}
        @Override public void setFrequency(int freq) {ISensor.super.setFrequency(freq);}


    @Override public SensorThread getThread(){ throw new UnsupportedOperationException();}
    @Override public void stopSensorThread(){throw new UnsupportedOperationException();}
    @Override public void startSensorThread(IAlgorithmStrategy generator){throw new UnsupportedOperationException();}
}

