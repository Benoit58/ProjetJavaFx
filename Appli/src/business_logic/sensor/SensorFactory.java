package business_logic.sensor;

public class SensorFactory {

    /**
     * Create ISensor by default
     *
     * @return the created ISensor
     */
    public static ISensor create(){
        return new Sensor();
    }

    /**
     * Create a Sensor
     *
     * @param sensorName the sensor name of the ISensor
     * @param temp the temperature of the ISensor
     * @param frequency the frequency/refresh of the ISensor
     * @return the created ISensor
     */
    public static ISensor create(String sensorName, int temp, int frequency){
        return new Sensor(sensorName, temp, frequency);
    }

    /**
     * Create a SuperSensor
     *
     * @param sensorName the superSensor name
     * @param sensor the ISensor to be Add
     * @return the created SuperSensor
     */
    public static ISensor create(String sensorName,ISensor sensor){
        return new SuperSensor(sensorName, sensor);
    }
}
