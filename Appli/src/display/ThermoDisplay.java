package display;

import controllers.ThermoDisplayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.ISensors;
import metier.algorithm.IAlgorithmStrategy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThermoDisplay implements Display{

    ThermoDisplayController thermo;

    @Override
    public void display(ISensors sensor){
        try{
            Stage thermometerWindow = new Stage();
            FXMLLoader thermometerLoader = new FXMLLoader(getClass().getResource("/ihm/thermoDisplay.fxml"));
            thermometerWindow.setScene(new Scene(thermometerLoader.load()));
            thermo = thermometerLoader.getController();
            thermo.load(sensor);
            thermometerWindow.setResizable(false);
            thermometerWindow.centerOnScreen();
            thermometerWindow.setTitle("Mon capteur");
            thermometerWindow.show();
        }catch(IOException e){
            Logger.getLogger(DigitalDisplay.class.getName()).log(Level.SEVERE, null, e);

        }

    }
}
