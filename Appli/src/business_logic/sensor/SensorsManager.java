package business_logic.sensor;


import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import business_logic.persistence.DataManager;

/**
 * Business class : SensorsManager : Manager to manage Sensors
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class SensorsManager {

    private static DataManager dataManager;

    private static final ListProperty<ISensor> sensorsCollection = new SimpleListProperty<>();
        public static ObservableList<ISensor> getSensors() { return sensorsCollection.get(); }
        public static void setSensors(ObservableList<ISensor> value){sensorsCollection.set(value);}
        public static ListProperty<ISensor> sensorsProperty(){return sensorsCollection; }

    /**
     * Set the DataManager
     *
     * @param dm the DataManager
     */
    public static void setDataManager(DataManager dm){ dataManager = dm; }

    /**
     * Call the loading method of the DataManager
     */
    public static void loadSensors(){
        if(dataManager != null){
            setSensors(FXCollections.observableList(dataManager.loadSensors()));
        }
    }

    /**
     * Call the saving method of the DataManager
     */
    public static void saveSensors(){
        if(dataManager != null){
            dataManager.saveSensors(getSensors());
        }
    }



}
