package metier.algorithm;

import metier.Sensor;
import metier.SensorThread;

import java.util.Random;

import static java.lang.Math.abs;

public class FenetreGlissante implements IAlgorithmStrategy {
    Sensor sensor;
    int coef;

    public FenetreGlissante(Sensor sensor, int coef){
        this.sensor = sensor;
        this.coef = coef;
    }

    public long getFrequency(){return sensor.getFrequency();}

    public int algorithm(){
        Random rand = new Random();
        return (sensor.getTemperature()+(rand.nextInt(abs(coef)*2)-coef)); //formule à vérif
    }

}
