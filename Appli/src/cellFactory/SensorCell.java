package cellFactory;

import controllers.SensorListViewUserControlController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.image.*;
import metier.ISensors;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SensorCell extends ListCell<ISensors> {

    private static final double IMAGE_HEIGHT = 36;
    private static final Image SENSOR_IMG = new Image("/img/sensor.png", 0, IMAGE_HEIGHT, true, true);

    private ImageView imageView = new ImageView();

    private Node renderer;
    private SensorListViewUserControlController rendererController;


    public SensorCell(){
        super();
        // Chargement du FXML.
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

    @Override
    protected void updateItem(ISensors item, boolean empty) {
        super.updateItem(item, empty);
        String text = null;
        Node graphic = null;
        if (empty || item == null) {
            imageView.setImage(null);
            setGraphic(null);
            setText(null);
        } else {
            //imageView.setImage(SENSOR_IMG);
            //setText(item.getSensorName());
            //setGraphic(imageView);

            graphic = renderer;
            rendererController.setLabel(item.getSensorName());
            rendererController.setSensor(item);
            setGraphic(graphic);
        }
    }
}