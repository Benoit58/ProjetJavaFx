package controller;

import business_logic.sensor.AbstractSensor;
import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import business_logic.sensor.SensorsManager;
import business_logic.algorithm.IAlgorithmStrategy;
import business_logic.algorithm.IntervalValue;
import business_logic.algorithm.RandomValue;

public class SensorListViewUserControlController {


    @FXML Label sensorName;
    @FXML ImageView state;
    @FXML ComboBox algoBox;



    Image start = new Image("/img/play.png");
    Image stop = new Image("/img/stop.png");

    Sensor context;



    public void sup(){
        context.stopSensorThread();
        SensorsManager.getSensors().remove(context);
    }

    public void setSensor(Sensor sensor)
    {
        this.context = sensor;
        sensorName.textProperty().bind(context.sensorNameProperty());
    }
    public Sensor getSensor(){return this.context;}

    public void startAndStopThread(){
        IAlgorithmStrategy generator = null;
        String algorithm = null;

        try {
            algorithm = algoBox.getValue().toString();
        } catch (NullPointerException e){
            algorithm = "Random";
        }
        switch(algorithm){
            case "Random" :
                generator = new RandomValue(context);
                break;

            case "Interval" :
                generator = new IntervalValue(context);
                break;

            case "RandInterval" :
                //generator = new FenetreGlissante(sensor);
                break;

            default :
                System.out.println("pas d'algo de selectionné");
                break;
        }

        if(context.getThread() != null){
            state.setImage(start);
            context.stopSensorThread();
        }else {
            context.startSensorThread(generator);
            state.setImage(stop);
        }
    }

    public void setLabel(String value) {
        sensorName.setText(value);
    }

}
