package metier.persistence;

import metier.sensor.ISensors;

import java.util.List;

/**
 * Public interface for metier.persistence management : serialisation
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
