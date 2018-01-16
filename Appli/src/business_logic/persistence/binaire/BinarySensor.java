package business_logic.persistence.binaire;

import business_logic.sensor.ISensor;
import business_logic.sensor.SensorFactory;
import business_logic.visitor.Visitor;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDate;

public class BinarySensor implements ISensor, Externalizable {

    public BinarySensor(){}


    public BinarySensor(ISensor model) {
        this.model = model;
    }

    private  ISensor model;

    public ISensor getModel() {
        return model;
    }

    @Override
    public StringProperty sensorNameProperty() {
        return model.sensorNameProperty();
    }

    @Override
    public IntegerProperty temperatureProperty() {
        return model.temperatureProperty();
    }

    @Override
    public Node accept(Visitor visitor) {throw new UnsupportedOperationException("Not supported");}


    @Override
    public void writeExternal(ObjectOutput oos) throws IOException {
        oos.writeObject(getSensorName());
        oos.writeInt(getTemperature());
    }

    @Override
    public void readExternal(ObjectInput ois) throws IOException, ClassNotFoundException {
        model = SensorFactory.create();
        this.setSensorName((String)ois.readObject());
        this.setTemperature(ois.readInt());
    }
}