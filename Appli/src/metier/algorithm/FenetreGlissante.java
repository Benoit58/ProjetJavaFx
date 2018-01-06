package metier.algorithm;

import metier.sensor.ISensors;

import java.util.Random;

import static java.lang.Math.abs;

public class FenetreGlissante implements IAlgorithmStrategy {

    ISensors sensor;
    int coef;

    public FenetreGlissante(ISensors sensor, int coef){
        this.sensor = sensor;
        this.coef = coef;
    }

    public long getFrequency(){return sensor.getFrequency();}

    public int algorithm(){
        Random rand = new Random();
        return (sensor.getTemperature()+(rand.nextInt(abs(coef)*2)-coef)); //formule à vérif
    }

}
