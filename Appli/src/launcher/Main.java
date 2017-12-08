package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load (getClass().getResource("/views/mainWindow.fxml"));
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        });

        try{
            Scene scene = new Scene(root, 640, 480);
            scene.getStylesheets().add(getClass().getResource("/views/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void closeProgram(Stage window){
        Boolean answer = ConfirmBox.display("QuitWindow","Are you sure you want to exit ?");
        if(answer)
            window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
