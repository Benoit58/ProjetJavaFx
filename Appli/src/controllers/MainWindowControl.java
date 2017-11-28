package controllers;

import metier.Sensor;
import model.SensorModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowControl implements Initializable {

    private ObservableList<Sensor> sensorList = FXCollections.observableArrayList();



    @FXML
    private ListView sensors;

    @FXML
    private Button buttonChange;

    @Override
    public void initialize(URL url, ResourceBundle resources){
        sensorList.add(new Sensor("Sensor 1",1));
        sensorList.add(new Sensor("Sensor 2", 2));

        sensors.setItems(sensorList);
    }

    @FXML
    private void newWindow(ActionEvent event) {
        //code du bouton
        Stage window = new Stage();
        VBox layout = new VBox();

        window.setTitle("WINDOW 2");
        window.setMinWidth(200);
        Scene scene= new Scene(layout, 300, 300);

        buttonChange.setOnAction(e -> window.setScene(scene));
    }
}
