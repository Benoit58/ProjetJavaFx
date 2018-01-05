package metier;

public class SensorsFactory {

    public static ISensors sensorFactory(){
        return new Sensor();
    }

    public static ISensors sensorFactory(String sensorName, int temp, int frequency){
        return new Sensor(sensorName, temp, frequency);
    }
}
