package display;

import controllers.DigitalDisplayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.ISensors;
import metier.algorithm.IAlgorithmStrategy;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DigitalDisplay implements Display{

    DigitalDisplayController digit;

    @Override
    public void display(ISensors sensor){
        try{
            Stage digitalWindow = new Stage();
            FXMLLoader digitalLoader = new FXMLLoader(getClass().getResource("/ihm/digitalDisplay.fxml"));
            digitalWindow.setScene(new Scene(digitalLoader.load()));
            digit = digitalLoader.getController();
            digit.load(sensor);
            digitalWindow.setResizable(false);
            digitalWindow.centerOnScreen();
            digitalWindow.setTitle("Mon capteur");
            digitalWindow.show();
        }catch (IOException e){
            Logger.getLogger(DigitalDisplay.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
