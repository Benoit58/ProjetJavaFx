package business_logic.sensor;

import business_logic.algorithm.IAlgorithmStrategy;
import javafx.beans.property.*;

/**
 * Business class : Sensor
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class Sensor implements ISensor {

    private SensorThread thread;

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

    /**
     * Sensor frequency property
     */
    private final IntegerProperty frequency = new SimpleIntegerProperty();

        /**
         * Get Sensor frequency property
         *
         * @return the IntegerProperty which corresponds to the Sensor frequency
         */
        @Override public IntegerProperty frequencyProperty(){return frequency;}


    /**
     * Default constructor : default values
     */
    Sensor(){
        setSensorName("");
        setTemperature(0);
        setFrequency(0);
    }

    /**
     * Constructor : set the attributes
     *
     * @param sensorName name of the Sensor
     * @param temperature temperature of the Sensor
     * @param frequency frequency of the Sensor
     */
    Sensor(String sensorName, int temperature, int frequency){
        setSensorName(sensorName);
        setTemperature(temperature);
        setFrequency(frequency);
    }

    /**
     * Get the Sensor Thread
     *
     * @return the sensor thread
     */
    public SensorThread getThread() {
        return thread;
    }

    /**
     * Start the Sensor thread with the selected temperature
     * generation algorithm
     *
     * @param generator the temperature generation algorithm
     */
    public void startSensorThread(IAlgorithmStrategy generator){
        this.setTemperature(generator.algorithm());
        thread = new SensorThread(this, generator);
        this.thread.start();
    }

    /**
     * Strop the Sensor thread
     */
    public void stopSensorThread(){
        thread.interrupt();
        thread = null;
    }

    /**
     * toString method
     *
     * @return Sensor as a String
     */
    public String toString(){
        return  String.format("%s - temp : %d - (f : %d)", getSensorName(), getTemperature(), getFrequency());
    }

}
