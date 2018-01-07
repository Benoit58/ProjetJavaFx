package cellFactory;

import business_logic.sensor.ISensor;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class SensorCellFactory implements Callback<ListView<ISensor>,ListCell<ISensor>> {

    @Override
    public ListCell<ISensor> call(ListView<ISensor> param) {
        return new SensorCell();
    }
}