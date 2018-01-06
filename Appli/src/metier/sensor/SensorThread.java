package metier.sensor;

import javafx.application.Platform;
import metier.algorithm.IAlgorithmStrategy;

public class SensorThread extends Thread implements Runnable{
    private  Sensor sensor;
    private IAlgorithmStrategy generator;

    public SensorThread(Sensor sensor, IAlgorithmStrategy generator){
        this.sensor = sensor;
        this.generator = generator;
    }

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
