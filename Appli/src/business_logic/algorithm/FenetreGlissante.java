package business_logic.algorithm;

import business_logic.sensor.ISensor;

import java.util.Random;

import static java.lang.Math.abs;

public class FenetreGlissante implements IAlgorithmStrategy {

    ISensor sensor;
    int coef;

    public FenetreGlissante(ISensor sensor, int coef){
        this.sensor = sensor;
        this.coef = coef;
    }

    public int algorithm(){
        Random rand = new Random();
        return (sensor.getTemperature()+(rand.nextInt(abs(coef)*2)-coef)); //formule à vérif
    }

}
