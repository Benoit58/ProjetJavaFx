package metier;

import javafx.application.Platform;

import java.util.Random;

public class SensorThread extends Thread {
    private  Sensor sensor;


    public SensorThread(Sensor sensor){
        this.sensor=sensor;
    }

    Random rand = new Random();
    @Override
    public void run() {
        while (true){

            Platform.runLater(() -> sensor.setTemperature(sensor.getTemperature()+rand.nextInt(4)-2));
            try {
                Thread.sleep(1000*sensor.getFrequency());
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
