package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import business_logic.sensor.ISensor;

import java.io.IOException;

public class ThermoDisplayController extends GridPane {

    @FXML Label maxLabel;
    @FXML Label tempLabel;
    @FXML Label minLabel;
    @FXML Rectangle rectangle;
    @FXML Label sensorName;
    @FXML GridPane grid;

    private ISensor sensor;
    private TilePane panes;

    public ThermoDisplayController(ISensor sensor,TilePane panes) throws IOException{
        this.sensor = sensor;
        this.panes = panes;
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/ihm/ThermoDisplay.fxml"));
        Loader.setController(this);
        Loader.setRoot(this);
        Loader.load();
    }

    @FXML
    public void closeDisplay(){
        panes.getChildren().remove(this);
    }

    public void initialize(){
        sensorName.textProperty().bind(sensor.sensorNameProperty());
        tempLabel.textProperty().bind((sensor.temperatureProperty().asString()));
        rectangle.heightProperty().bind(sensor.temperatureProperty().multiply(90).divide(200).add(45));
        grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    }
}
