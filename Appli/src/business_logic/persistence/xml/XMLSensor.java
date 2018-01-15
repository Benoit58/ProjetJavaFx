package business_logic.persistence.xml;

import business_logic.visitor.Visitor;
import javafx.beans.property.*;
import business_logic.sensor.ISensor;
import business_logic.sensor.SensorThread;
import business_logic.sensor.SensorFactory;
import business_logic.algorithm.IAlgorithmStrategy;

import java.io.*;

/**
 * Business class for XML persistence management : Serializable Sensor used as a proxy to serialize ISensor
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
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

    /**
     * ISensor name Property to be serialized
     */
    private final StringProperty sensorName;
        @Override public StringProperty sensorNameProperty() {return model.sensorNameProperty();}
        @Override public  String getSensorName() {return ISensor.super.getSensorName();}
        @Override public void setSensorName(String name) {ISensor.super.setSensorName(name);}

    /**
     * ISensor temperature Property to be serialized
     */
    private final IntegerProperty temp;
        @Override public IntegerProperty temperatureProperty() {return model.temperatureProperty();}
        @Override public int getTemperature() {return ISensor.super.getTemperature();}
        @Override public void setTemperature(int temp) {ISensor.super.setTemperature(temp);}

    @Override
    public void accept(Visitor visitor){
            throw new UnsupportedOperationException("Not supported");
    }
}

