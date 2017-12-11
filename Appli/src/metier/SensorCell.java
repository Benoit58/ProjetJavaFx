package metier;

import javafx.scene.control.ListCell;
import javafx.scene.image.*;

public class SensorCell extends ListCell<Sensor> {

    private static final double IMAGE_HEIGHT = 36;

    private static final Image SENSOR_IMG = new Image("/img/sensor.png", 0, IMAGE_HEIGHT, true, true);

    private ImageView imageView = new ImageView();

    @Override
    protected void updateItem(Sensor item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            imageView.setImage(null);
            setGraphic(null);
            setText(null);
        } else {
            imageView.setImage(SENSOR_IMG);
            setText(item.getSensorName());
            setGraphic(imageView);
        }
    }
}