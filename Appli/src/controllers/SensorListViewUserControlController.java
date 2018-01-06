package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.ISensors;
import metier.SensorsManager;
import metier.algorithm.IAlgorithmStrategy;
import metier.algorithm.IntervalValue;
import metier.algorithm.RandomValue;

public class SensorListViewUserControlController {

    @FXML
    Label sensorName;
    @FXML
    ImageView state;
    @FXML
    ComboBox algoBox;

    Image start = new Image("/img/play.png");
    Image stop = new Image("/img/stop.png");

    ISensors context;

    public void sup(){
        SensorsManager.getSensors().remove(context); }

    public void setSensorModel(ISensors sensor)
    {
        this.context = sensor;
    }
    public void setSensor(ISensors sensor)
    {
        this.context = sensor;
    }
    public ISensors getSensor(){return this.context;}

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
