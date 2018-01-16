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

/**
 * Business class for Binary persistence management : Serializable Sensor used as a proxy to serialize ISensor
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class BinarySensor implements ISensor, Externalizable {

    /**
     * Create an BinarySensor by default
     */
    public BinarySensor(){}

    /**
     * Create a BinarySensor using an ISensor
     *
     * @param model the ISensor to convert in BinarySensor
     */
    public BinarySensor(ISensor model) {
        this.model = model;
    }

    private  ISensor model;


    /**
     * Get the ISensor who corresponds to the BinarySensor
     *
     * @return the ISensor as model to create the BinarySensor
     */
    public ISensor getModel() {
        return model;
    }

    /**
     * ISensor name Property to be serialized
     *
     * @return  StringProperty correspond to sensor name
     */
    @Override
    public StringProperty sensorNameProperty() {
        return model.sensorNameProperty();
    }

    /**
     *
     * ISensor temperature Property to be serialized
     *
     * @return IntegerProperty correspond to sensor temperature
     */
    @Override
    public IntegerProperty temperatureProperty() {
        return model.temperatureProperty();
    }

    /**
     *
     * @param visitor
     * @return Node
     */
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