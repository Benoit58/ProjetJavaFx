package cellFactory;

import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import business_logic.sensor.SuperSensor;
import business_logic.visitor.SensorVisitor;
import business_logic.visitor.Visitor;
import controller.SensorListViewUserControlController;
import controller.SensorListViewUserController2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.image.*;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Business logic class for cellFactory management : SensorCell : Manage ListView sensor cells
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */
public class SensorCell extends ListCell<ISensor> {

    private static final double IMAGE_HEIGHT = 36;
    private static final Image SENSOR_IMG = new Image("/img/sensor.png", 0, IMAGE_HEIGHT, true, true);

    private ImageView imageView = new ImageView();

    private Visitor sensorVisitor = new SensorVisitor();

    /**
     * Update the ListView
     *
     * @param item an item to update
     * @param empty a boolean to know if the item must be re-init
     */
    @Override
    protected void updateItem(ISensor item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            imageView.setImage(null);
            setGraphic(null);
            setText(null);
        }
        else
        setGraphic(item.accept(sensorVisitor));
    }
}