package business_logic.visitor;

import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import business_logic.sensor.SuperSensor;
import controller.SensorListViewUserControlController;
import controller.SensorListViewUserController2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;


public class SensorVisitor extends Visitor{
    private Node renderer;

    public Node visit(Sensor sensor) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/SensorListViewUserControl.fxml"));
        try {
            renderer = loader.load();
            ((SensorListViewUserControlController)loader.getController()).setSensor(sensor);
            return renderer;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Node visit(SuperSensor superSensor){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ihm/SensorListViewUserControl2.fxml"));
        try {
            renderer = loader.load();
            ((SensorListViewUserController2)loader.getController()).setSensor(superSensor);
            return renderer;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

