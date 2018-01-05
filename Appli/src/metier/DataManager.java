package metier;

import javafx.collections.ObservableList;
import metier.ISensors;
import metier.Sensor;

import java.util.List;

public interface DataManager{
     public List<ISensors> loadSensors();
     public void writeSensors(List<ISensors> sensors);

}
