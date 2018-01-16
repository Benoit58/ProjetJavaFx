package controller;

import business_logic.sensor.ISensor;
//import business_logic.sensor.SensorFactory;
import business_logic.sensor.SensorsManager;
import cellFactory.SensorCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddSuperSensorController extends BorderPane implements Initializable{

    @FXML  TextField sensorName;
    @FXML  Button validButton;
    @FXML  Button stopButton;
    @FXML  ListView<ISensor> sensorList;
    @FXML  Button addSensor;
    @FXML Button quitButton;

    private ISensor selectedCapteur;
    private ObservableList<ISensor> sensorCollection;

    //public AddSuperSensorController(ObservableList<ISensor> list){ sensorCollection=FXCollections.observableList(list); }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sensorList.setItems(SensorsManager.getSensors());
        /*validButton.setOnMousePressed(me -> commitCapteur());
        stopButton.setOnMousePressed(me -> stopButton.getScene().getWindow().hide());
        sensorList.setOnMouseClicked(me -> selectedCapteur= sensorList.getSelectionModel().getSelectedItem());
        sensorList.setItems(sensorCollection);*/
    }

    /*@FXML
    public void addSuperSensor(ISensor sensor, int poids){
        if(sensorName.getText().isEmpty() || sensorList.getItems().isEmpty()){
            System.out.println("VIDE");
            //errorMessage.setVisible(true);
        }else{
            SensorsManager.getSensors().add(SensorFactory.create(sensorName.getText()));
            quit();
        }
    }*/

    public void quit() {
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }

    public void addSuperSensor(ActionEvent actionEvent) {
    }
}