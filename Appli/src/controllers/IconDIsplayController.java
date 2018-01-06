package controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.ISensors;
import metier.Sensor;


public class IconDisplayController {
    Image sun=new Image("/img/sun.png");
    Image cloud=new Image("/img/cloud.png");
    Image snowflake=new Image("/img/snowflake.png");

    @FXML
    Label sensorName;

    @FXML
    ImageView icon;

    public void load(ISensors sensor){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        sensor.temperatureProperty().addListener((o,oldV,newV)->{
            if ((int) newV < 0) icon.setImage(snowflake);
            if ((int) newV > 20) icon.setImage(sun);
            if ((int) newV >= 0 && (int) newV <= 20) icon.setImage(cloud);
        });
    }
}
