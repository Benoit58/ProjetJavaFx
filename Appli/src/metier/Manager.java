package metier;


import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Façade de la partie Metier
 */
public class Manager{

    public Manager(){}

    /**
     * Constructeur qui prend en paramètre le DataManager que l'on souhaite
     * @param dm le DataManager que l'on choisi : pour le moment --> XMLDataManager
     */
    public Manager(DataManager dm){
        setDataManager(dm);
        if(dataManager != null){
            loadSensors();
        }
    }

    //les capteurs
    private ObservableList<ISensors> sensorListObs = FXCollections.observableArrayList();
    private final ListProperty<ISensors> sensorsCollection = new SimpleListProperty<>(sensorListObs);
        public ObservableList<ISensors> getSensors() { return sensorsCollection.get(); }
        //public void setSensors(ObservableList<Sensor> value){sensors.set(value);}
        public ReadOnlyListProperty<ISensors> sensorsProperty(){return sensorsCollection; }

    //celui qui va gérer la persistance
    private DataManager dataManager;

    public void setDataManager(DataManager dm){
        this.dataManager = dm;
    }


    /**
     * le manager récupère la collection de capteurs en déléguant cette
     * responsabilité au dataManager
     */
    public void loadSensors(){
        if(dataManager != null){
            List<ISensors> result = dataManager.loadSensors();
            if(result != null){
                getSensors().clear();
                getSensors().addAll(dataManager.loadSensors());
            }
        }
    }

    /**
     * le manager récupère la collection de capteurs en déléguant cette
     * responsabilité au dataManager
     */
    public void writeSensors(){
        if(dataManager != null){
            dataManager.writeSensors(getSensors());
        }
    }



}
