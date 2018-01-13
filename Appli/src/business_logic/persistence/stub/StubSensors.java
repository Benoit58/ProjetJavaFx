package business_logic.persistence.stub;

import business_logic.sensor.ISensor;
import business_logic.sensor.SensorFactory;
import business_logic.persistence.DataManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Business class for stub management : StubSensors : Initialisation of the data which refers to Sensors
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class StubSensors implements DataManager {

    /**
     * Load the below list of sensors
     *
     * @return the list of Sensors
     */
    @Override
    public List<ISensor> loadSensors(){
        List<ISensor> sensors = new ArrayList<ISensor>();
        sensors.add(SensorFactory.create("Bureau", 20, 1));
        sensors.add(SensorFactory.create("Salon", 25, 4));
        sensors.add(SensorFactory.create("Cuisine", 28, 12));
        return sensors;
    }

    /**
     * Save Sensors : not implemented
     *
     * @param sensors the List of Users to save
     */
    @Override
    public void saveSensors(List<ISensor> sensors){
        throw new UnsupportedOperationException("Not Supported Yet");
    }
}
