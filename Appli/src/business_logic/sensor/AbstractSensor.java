package business_logic.sensor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 */
public abstract  class AbstractSensor implements ISensor{

    /**
     * Sensor name property
     */
    private final StringProperty sensorName = new SimpleStringProperty();
    /**
     * Get Sensor name property
     *
     * @return the StringProperty which corresponds to the Sensor name
     */
    @Override public StringProperty sensorNameProperty() { return sensorName; }

    /**
     * Sensor temperature property
     */
    private final IntegerProperty temperature = new SimpleIntegerProperty();
    /**
     * Get Sensor temperature property
     *
     * @return the IntegerProperty which corresponds to the Sensor temperature
     */
    @Override public IntegerProperty temperatureProperty(){return temperature;}
}
