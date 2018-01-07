package business_logic.persistence;

import business_logic.sensor.ISensor;

import java.util.List;

/**
 * Public interface for business_logic.persistence management : serialisation
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public interface DataManager{

     /**
      * Deserialize the Sensors
      *
      * @return the loaded Sensors Collection
      */
     public List<ISensor> loadSensors();

     /**
      * Serialize the Sensors
      *
      * @param sensors the collection to serialize
      */
     public void saveSensors(List<ISensor> sensors);

}
