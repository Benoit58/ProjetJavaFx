package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.Sensor;
import model.SensorModel;

import java.io.IOException;

public class SensorListViewUserControlController{
    @FXML
    Label sensorName;

    @FXML
    ImageView state;

    Image start = new Image("/img/play.png");
    Image stop = new Image("/img/stop.png");



    SensorModel sensorModel;
    Sensor sensor;



    public void sup(){
        sensorModel.getSensors().remove(sensor);
    }

    public void setSensorModel(SensorModel sensorModel)
    {
        this.sensorModel = sensorModel;
    }
    public void setSensor(Sensor sensor)
    {
        this.sensor = sensor;
    }

    public void startAndStopThread(){
        if(sensor.getThread()!=null){
            state.setImage(start);
            sensor.stopSensorThread();
        }else {
            sensor.startSensorThread();
            state.setImage(stop);
        }
    }

    public void setLabel(String value) {
        sensorName.setText(value);
    }
}
