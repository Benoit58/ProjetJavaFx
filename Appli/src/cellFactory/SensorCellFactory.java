package cellFactory;

import business_logic.sensor.ISensor;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * Business logic class for cellFactory management : SensorCellFactory
 * Create ListView with ISensors
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class SensorCellFactory implements Callback<ListView<ISensor>,ListCell<ISensor>> {
    /**
     * Create a ListView item
     *
     * @param param a ListView param of Sensor
     * @return SensorCell wich is a ListView item
     */
    @Override
    public ListCell<ISensor> call(ListView<ISensor> param) {
        return new SensorCell();
    }
}