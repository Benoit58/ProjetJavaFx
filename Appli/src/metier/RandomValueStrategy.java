package metier;

import java.util.Random;

public class RandomValueStrategy implements IAlgorithmStrategy {

    public int algorithm(){
        Random rand = new Random();
        return rand.nextInt(30) + 1;
    }

}
