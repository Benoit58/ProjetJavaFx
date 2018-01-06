package display;


import controllers.IconDisplayController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.ISensors;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IconDisplay implements Display{
    IconDisplayController icon;

    @Override
    public void display(ISensors sensor) {
        try {
            Stage iconWindow = new Stage();
            FXMLLoader iconLoader = new FXMLLoader(getClass().getResource("/ihm/iconDisplay.fxml"));
            iconWindow.setScene(new Scene(iconLoader.load()));
            icon = iconLoader.getController();
            icon.load(sensor);
            iconWindow.setResizable(false);
            iconWindow.centerOnScreen();
            iconWindow.setTitle("Mon capteur");
            iconWindow.show();
        } catch (IOException e) {
            Logger.getLogger(DigitalDisplay.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
