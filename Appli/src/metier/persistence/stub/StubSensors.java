package metier.persistence.stub;

import metier.sensor.ISensors;
import metier.sensor.SensorsFactory;
import metier.persistence.DataManager;

import java.util.ArrayList;
import java.util.List;

public class StubSensors implements DataManager {


    /**
     * Load the below list of sensors
     *
     * @return the list of Sensors
     */
    @Override
    public List<ISensors> loadSensors(){
        List<ISensors> sensors = new ArrayList<ISensors>();
        sensors.add(SensorsFactory.sensorFactory("Bureau", 20, 1));
        sensors.add(SensorsFactory.sensorFactory("Salon", 25, 4));
        sensors.add(SensorsFactory.sensorFactory("Cuisine", 28, 12));
        return sensors;
    }


    /**
     * Save Sensors : not implemented
     *
     * @param sensors the List of Users to save
     */
    @Override
    public void writeSensors(List<ISensors> sensors){
        throw new UnsupportedOperationException("Not Supported Yet");
    }
}
