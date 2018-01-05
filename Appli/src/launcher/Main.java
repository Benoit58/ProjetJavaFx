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

    private Manager manager;

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

        //on assigne le manager au controller
        controller.setManager(manager);
    }

    private void closeProgram(Stage window){
        Boolean answer = ConfirmBox.display("QuitWindow","Are you sure you want to exit ?");
        if(answer)
            window.close();

    }

    private void loadSensors(){
        manager = new Manager(new XMLDataManager());

        //si il n'y a pas de sensors de chargés, on load la stub
        if(manager.getSensors().isEmpty()) {
            manager.setDataManager(new StubDataManager());
            manager.loadSensors();
        }
    }

    private void saveSensors(){
        manager.setDataManager(new XMLDataManager());
        manager.writeSensors();
    }

    @Override
    public void stop(){
        saveSensors();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
