package cellFactory;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import metier.ISensors;

public class SensorCellFactory implements Callback<ListView<ISensors>,ListCell<ISensors>> {

    @Override
    public ListCell<ISensors> call(ListView<ISensors> param) {
        return new SensorCell();
    }
}