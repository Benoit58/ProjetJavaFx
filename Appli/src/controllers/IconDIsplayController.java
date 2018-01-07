package controllers;

import business_logic.sensor.ISensor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;


public class IconDisplayController extends GridPane {

    private Image sun=new Image("/img/sun.png");
    private Image cloud=new Image("/img/cloud.png");
    private Image snowflake=new Image("/img/snowflake.png");

    @FXML Label sensorName;
    @FXML ImageView icon;

    private ISensor sensor;

    public IconDisplayController(ISensor sensor) throws IOException{
        this.sensor = sensor;
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/ihm/IconDisplay.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
    }

    public void initialize(){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        sensor.temperatureProperty().addListener((o,oldV,newV)->{
            if ((int) newV < 0) icon.setImage(snowflake);
            if ((int) newV > 20) icon.setImage(sun);
            if ((int) newV >= 0 && (int) newV <= 20) icon.setImage(cloud);
        });
    }
}
