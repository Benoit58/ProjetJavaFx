package launcher;

import controllers.RootLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< HEAD
=======
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainWindow.fxml"));

        window = primaryStage;
        window.setTitle("JAVAFX - Project");
        window.show();
        window.setOnCloseRequest(event -> {
            event.consume();  //ctrl+Q to check the meaning of the method
            closeProgram();
        });

        BorderPane grid = new BorderPane();
>>>>>>> 07d4139084b87626e0731df42e7fa670987d4eb1

        Parent root = FXMLLoader.load (getClass().getResource("/views/RootLayout.fxml"));
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
