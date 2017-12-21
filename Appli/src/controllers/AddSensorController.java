package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.stage.Window;
import metier.Sensor;
import model.SensorModel;

import java.awt.*;

public class AddSensorController {

    @FXML
    private TextField name;

    @FXML
    private TextField temp;

    @FXML
    private TextField frequency;

    @FXML
    private Label errorMessage;

    @FXML
    public Button quitButton;

    @FXML
    public Button addButton;

    SensorModel sensorModel;

    public void addSensor(){
        if(name.getText().isEmpty()|| frequency.getText().isEmpty() || temp.getText().isEmpty()){
            errorMessage.setVisible(true);
        }else{
            sensorModel.getSensors().add(new Sensor(name.getText(),Integer.parseInt(temp.getText()),Integer.parseInt(frequency.getText())));
            quit();
        }
    }

    public void quit() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public void getSensorModel(SensorModel sensorModel)
    {
        this.sensorModel = sensorModel;
    }


}
