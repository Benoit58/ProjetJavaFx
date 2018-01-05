package launcher;

import controllers.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import metier.Manager;
import persistence.XML.XMLDataManager;
import persistence.stub.StubDataManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //on load les sensors
        loadSensors();

        //on charge la fenêtre
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        });
        MainWindowController controller = fxmlLoader.getController();
        root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
        primaryStage.setScene(new Scene(root));
        //primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    private void closeProgram(Stage window){
        Boolean answer = ConfirmBox.display("QuitWindow","Are you sure you want to exit ?");
        if(answer)
            window.close();

    }

    private void loadSensors(){
        Manager.setDataManager(new XMLDataManager());
        Manager.loadSensors();
        if(Manager.getSensors().isEmpty()){
            Manager.setDataManager(new StubDataManager());
            Manager.loadSensors();
        }
    }

    private void saveSensors(){
        Manager.setDataManager(new XMLDataManager());
        Manager.writeSensors();
    }

    @Override
    public void stop(){
        saveSensors();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
