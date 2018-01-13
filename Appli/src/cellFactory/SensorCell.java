package cellFactory;

import business_logic.sensor.ISensor;
import controller.SensorListViewUserControlController;
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

    private Node renderer;
    private SensorListViewUserControlController rendererController;

    /**
     * Constructor of a SensorCell : load the fxml
     */
    public SensorCell(){
        super();
        try {
            final URL fxmlURL = getClass().getResource("/ihm/SensorListViewUserControl.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            renderer = fxmlLoader.load();
            rendererController =  fxmlLoader.getController();
            rendererController.setSensorModel(getItem());
        } catch (IOException ex) {
            Logger.getLogger(SensorCell.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /**
     * Update the ListView
     *
     * @param item an item to update
     * @param empty a boolean to know if the item must be re-init
     */
    @Override
    protected void updateItem(ISensor item, boolean empty) {
        super.updateItem(item, empty);
        String text = null;
        Node graphic = null;
        if (empty || item == null) {
            imageView.setImage(null);
            setGraphic(null);
            setText(null);
        } else {
            graphic = renderer;
            rendererController.setLabel(item.getSensorName());
            rendererController.setSensor(item);
            setGraphic(graphic);
        }
    }
}