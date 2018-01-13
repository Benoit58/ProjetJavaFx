package business_logic.sensor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Business interface : ISensor
 *
 * This interface allows both Sensor and SuperSensor to
 * benefit from this methods
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public interface ISensor {

    /**
     * Get ISensor name
     *
     * @return the ISensor name
     */
    default String getSensorName() {return sensorNameProperty().get();}
    /**
     * Set ISensor name
     *
     * @param name the name to be set
     */
    default void setSensorName(String name) {this.sensorNameProperty().set(name);}

    /**
     * Get ISensor temperature
     *
     * @return the ISensor temperature
     */
    default int getTemperature() {return temperatureProperty().get();}
    /**
     * Set Isensor temperature
     *
     * @param temperature the temperature to be set
     */
    default void setTemperature(int temperature) {this.temperatureProperty().set(temperature);}

    /**
     * ISensor sensorName property
     *
     * @return the StringProperty which corresponds to the sensor name
     */
     StringProperty sensorNameProperty();
    /**
     * ISensor temperature property
     *
     * @return the IntegerProperty which corresponds to the sensor temperature
     */
     IntegerProperty temperatureProperty();
}
