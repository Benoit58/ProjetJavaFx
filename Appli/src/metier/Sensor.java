package metier;

public class Sensor {

    private String nom;
    private int temp;

    public Sensor(String nom, int temp) {
        this.nom=nom;
        this.temp=temp;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public int getTemp(){
        return temp;
    }

    public void setTemp(int temp){
        this.temp = temp;
    }

    @Override
    public String toString(){
        return "Sensor : " + nom + " temp : " + temp ;
    }
}
