package controller;

import business_logic.sensor.AbstractSensor;
import business_logic.sensor.ISensor;
import business_logic.sensor.SuperSensor;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import business_logic.sensor.SensorsManager;
import business_logic.algorithm.IAlgorithmStrategy;
import business_logic.algorithm.IntervalValue;
import business_logic.algorithm.RandomValue;

public class SensorListViewUserController2 {

    @FXML Label sensorName;

    Image start = new Image("/img/play.png");
    Image stop = new Image("/img/stop.png");

    private SuperSensor context;

    public void sup(){
        SensorsManager.getSensors().remove(context);
    }

    public void setSensor(SuperSensor sensor)
    {
        this.context = sensor;
        sensorName.textProperty().bind(context.sensorNameProperty());

    }
    public SuperSensor getSensor(){return this.context;}

    public void setLabel(String value) {
        sensorName.setText(value);
    }

}
