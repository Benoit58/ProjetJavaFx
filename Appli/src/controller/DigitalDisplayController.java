package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import business_logic.sensor.ISensor;
import javafx.scene.paint.Color;

import java.io.IOException;

public class DigitalDisplayController extends GridPane {

    @FXML Label sensorName;
    @FXML Label sensorTemp;
    @FXML Button deleteButton;
    @FXML GridPane grid;

    private ISensor sensor;
    private TilePane panes;

    public DigitalDisplayController(ISensor sensor,TilePane pane) throws IOException {
        this.sensor = sensor;
        this.panes = pane;
        FXMLLoader leLoader = new FXMLLoader(getClass().getResource("/ihm/DigitalDisplay.fxml"));
        leLoader.setController(this);
        leLoader.setRoot(this);
        leLoader.load();
    }

    @FXML
    public void closeDisplay(){
        panes.getChildren().remove(this);
    }

    public void initialize(){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        sensorTemp.textProperty().bind((sensor.temperatureProperty().asString()));
        grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}
