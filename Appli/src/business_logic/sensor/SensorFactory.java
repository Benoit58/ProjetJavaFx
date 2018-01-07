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
     * Create A Sensor
     *
     * @param sensorName the sensor name of the ISensor
     * @param temp the temperature of the ISensor
     * @param frequency the frequency/refresh of the ISensor
     * @return the created ISensor
     */
    public static ISensor create(String sensorName, int temp, int frequency){
        return new Sensor(sensorName, temp, frequency);
    }


    public static ISensor create(String sensorName,)
}
