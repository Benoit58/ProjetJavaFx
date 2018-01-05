package persistence.XML;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.ISensors;
import metier.Sensor;
import metier.SensorThread;
import metier.SensorsFactory;
import metier.algorithm.IAlgorithmStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLSensors implements ISensors, Serializable {

    private transient ISensors model;

    public XMLSensors(){
        this(SensorsFactory.sensorFactory());
    }

    public XMLSensors(ISensors model) {
        this.model = model;
        sensorName = new SimpleStringProperty(model.getSensorName());
        temp = new SimpleIntegerProperty(model.getTemperature());
        frequency = new SimpleIntegerProperty(model.getFrequency());
    }

    public ISensors getModel() {
        return model;
    }

    private final StringProperty sensorName;
        @Override public StringProperty sensorNameProperty() {return model.sensorNameProperty();}
        @Override public  String getSensorName() {return ISensors.super.getSensorName();}
        @Override public void setSensorName(String name) {ISensors.super.setSensorName(name);}

    private final IntegerProperty temp;
        @Override public IntegerProperty temperatureProperty() {return model.temperatureProperty();}
        @Override public int getTemperature() {return ISensors.super.getTemperature();}
        @Override public void setTemperature(int temp) {ISensors.super.setTemperature(temp);}

    private final IntegerProperty frequency;
        @Override public IntegerProperty frequencyProperty() {return model.frequencyProperty();}
        @Override public int getFrequency() {return ISensors.super.getFrequency();}
        @Override public void setFrequency(int freq) {ISensors.super.setFrequency(freq);}


    @Override
    public SensorThread getThread(){return model.getThread();}

    @Override
    public void stopSensorThread(){
        model.getThread().interrupt();
    }

    @Override
    public void startSensorThread(IAlgorithmStrategy generator){

    }
}

