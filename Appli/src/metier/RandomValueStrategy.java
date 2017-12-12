package metier;

import java.util.Random;

public class RandomValueStrategy implements AlgorithmStrategy {

    public int algorithm(){
        Random rand = new Random();
        return rand.nextInt(30) + 1;
    }

}
