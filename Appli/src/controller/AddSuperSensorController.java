package controller;

import business_logic.sensor.ISensor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSuperSensorController extends BorderPane implements Initializable{

    @FXML  TextField idSensor;
    @FXML  TextField sensorName;
    @FXML  Button validButton;
    @FXML  Button stopButton;
    @FXML  ListView<ISensor> sensorList;
    @FXML  Button addSensor;

    private ISensor selectedCapteur;
    private ObservableList<ISensor> sensorCollection;

    public AddSuperSensorController(ObservableList<ISensor> list){ sensorCollection=FXCollections.observableList(list); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validButton.setOnMousePressed(me -> commitCapteur());
        stopButton.setOnMousePressed(me -> stopButton.getScene().getWindow().hide());
        sensorList.setOnMouseClicked(me -> selectedCapteur= sensorList.getSelectionModel().getSelectedItem());
        sensorList.setItems(sensorCollection);
    }

    @FXML
    public void addSensor(ISensor sensor, int poids){
        SensorPoids sens = new SensorPoids(sensor, poids);
        getSensorList().add(sens);
    }
}