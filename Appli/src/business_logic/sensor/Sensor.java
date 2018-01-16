package business_logic.sensor;

import business_logic.algorithm.IAlgorithmStrategy;
import business_logic.visitor.SensorVisitor;
import business_logic.visitor.Visitor;
import javafx.beans.property.*;
import javafx.scene.Node;

/**
 * Business class : Sensor
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class Sensor extends AbstractSensor {

    private SensorThread thread;

    /**
     * Sensor frequency property
     */
    private final IntegerProperty frequency = new SimpleIntegerProperty();
        public int getFrequency(){return frequency.get();}
        public void setFrequency(int freq){frequency.set(freq);}
        public IntegerProperty frequencyProperty(){return this.frequency;}

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


    /**
     * accepte le visiteur
     * @param sensorVisitor
     * @return
     */
    @Override
    public Node accept(Visitor sensorVisitor)
    {
        return sensorVisitor.visit(this);
    }

}
