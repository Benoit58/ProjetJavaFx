package metier;

public class SensorThread extends Thread {
    private  Sensor sensor;


    public SensorThread(Sensor sensor){
        this.sensor=sensor;
    }


    @Override
    public void run() {
        while (true){


            sensor.setTemperature(sensor.getTemperature()+1);
            try {
                Thread.sleep(1000*sensor.getFrequency());
            } catch (InterruptedException e) {
                break;
            }

        }
    }
}
