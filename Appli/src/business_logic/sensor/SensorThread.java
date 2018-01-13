package business_logic.sensor;

import javafx.application.Platform;
import business_logic.algorithm.IAlgorithmStrategy;

/**
 * Business class : SensorThread : manage sensors temperature
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class SensorThread extends Thread implements Runnable{

    private Sensor sensor;
    private IAlgorithmStrategy generator;

    /**
     * Sensor Thread constructor
     *
     * @param sensor the sensor
     * @param generator the temperature generation algorithm
     */
    public SensorThread(Sensor sensor, IAlgorithmStrategy generator){
        this.sensor = sensor;
        this.generator = generator;
    }

    /**
     * Start the Thread
     */
    @Override
    public void run() {
        while (true){
            try {
                sleep(sensor.getFrequency()*1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
            if(generator == null){
                Platform.runLater(() -> sensor.setTemperature(sensor.getTemperature() - 1 ));
            }
            else{
                Platform.runLater(() -> sensor.setTemperature(generator.algorithm()));
            }
        }
    }
}
