package persistence;

import javafx.collections.ObservableList;
import metier.ISensors;
import metier.Sensor;

import java.util.List;

/**
 * Public interface for persistence management : serialisation
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public interface DataManager{

     /**
      * Deserialize the Sensors
      *
      * @return the loaded Sensors Collection
      */
     public List<ISensors> loadSensors();

     /**
      * Serialize the Sensors
      *
      * @param sensors the collection to serialize
      */
     public void writeSensors(List<ISensors> sensors);

}
