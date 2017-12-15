package metier;

public class IntervalValueStrategy implements IAlgorithmStrategy {

    //Math.random --> value in [0, 1[
    public int algorithm(){
        int min=14, max=21;
        return min + (int) (Math.random() * ((1 + max) - min));
    }
}
