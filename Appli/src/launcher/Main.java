package launcher;

import business_logic.persistence.binaire.BinaryDataManager;
import business_logic.sensor.AbstractSensor;
import business_logic.sensor.ISensor;
import business_logic.sensor.Sensor;
import controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import business_logic.sensor.SensorsManager;
import business_logic.persistence.stub.StubSensors;
import business_logic.persistence.xml.XMLDataManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //on load les sensors
        loadSensors();

        //on charge la fenêtre
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ihm/MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        });
        MainWindowController controller = fxmlLoader.getController();
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    private void closeProgram(Stage window){
        Boolean answer = ConfirmBox.display("QuitWindow","Are you sure you want to exit ?");
        if(answer)
            window.close();

    }

    private void loadSensors() {
        /*
        SensorsManager.setDataManager(new StubSensors());
        SensorsManager.loadSensors();
        */

        /*SensorsManager.setDataManager(new XMLDataManager());
        SensorsManager.loadSensors();
        if(SensorsManager.getSensors().isEmpty()){
            SensorsManager.setDataManager(new StubSensors());
            SensorsManager.loadSensors();
        }*/

        SensorsManager.setDataManager(new BinaryDataManager());
        SensorsManager.loadSensors();
        if (SensorsManager.getSensors().isEmpty()) {
            SensorsManager.setDataManager(new StubSensors());
            SensorsManager.loadSensors();
        }
    }

    private void saveSensors(){
        /*
        SensorsManager.setDataManager(new XMLDataManager());
        SensorsManager.saveSensors();
        */

        SensorsManager.setDataManager(new BinaryDataManager());
        SensorsManager.saveSensors();



    }

    @Override
    public void stop(){
        for (ISensor s:SensorsManager.getSensors() ) {
            if (s instanceof Sensor)
                if (((Sensor) s).getThread() != null)
                    ((Sensor) s).stopSensorThread();
        }
        saveSensors();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
