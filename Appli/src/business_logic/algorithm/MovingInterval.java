package business_logic.algorithm;



import business_logic.sensor.ISensor;
import java.util.Random;
import static java.lang.Math.abs;


/**
 * Business class : fenetreGlissante algorithm
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class MovingInterval implements IAlgorithmStrategy {

    ISensor sensor;
    int coef;

    /**
     * Constructor
     *
     * @param sensor
     * @param coef
     */
    public MovingInterval(ISensor sensor, int coef){
        this.sensor = sensor;
        this.coef = coef;
    }


    /**
     * generate temperature between moving interval
     * @return int: temperature
     */
    public int algorithm(){
        Random rand = new Random();
        return (sensor.getTemperature()+(rand.nextInt(abs(coef)*2)-coef)); //formule à vérif
    }

}
