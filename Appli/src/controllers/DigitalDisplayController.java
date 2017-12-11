package controllers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import metier.Sensor;
import java.awt.*;

public class DigitalDisplayController {

    @FXML
    Label sensorName;

    private ObjectProperty<Sensor> mySensor= new SimpleObjectProperty<>();
    public final Sensor getMySensor()  { return mySensor.get(); }
    public final void setMySensor(Sensor value) { mySensor.set(value); }
    public ObjectProperty<Sensor> moySensorProperty() {return mySensor;}


    public void load(Sensor sensor){
        setMySensor(sensor);
        sensorName.setText(sensor.getSensorName());
    }
}
