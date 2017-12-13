package metier;

public class AlgorithmContext{
    private AlgorithmStrategy strategy;

    public void setAlgorithmStrategy(AlgorithmStrategy strategy){
        this.strategy = strategy;
    }

    //use the generation strategy
    //public int generateValue(){
        //return strategy.algorithm(algorithm);
    //}
}
