package cellFactory;

import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import business_logic.sensor.SuperSensor;
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

        try {
            if(item instanceof Sensor){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/SensorListViewUserControl.fxml"));
                setGraphic(loader.load());
                ((SensorListViewUserControlController)loader.getController()).setSensor((Sensor) item);
            }
            else if(item instanceof SuperSensor){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/SensorListViewUserControl2.fxml"));
                setGraphic(loader.load());
                ((SensorListViewUserController2)loader.getController()).setSensor((SuperSensor) item);
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}