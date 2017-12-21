package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load (getClass().getResource("/views/MainWindow.fxml"));
        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            closeProgram(primaryStage);
        });
        try{
            root.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
            primaryStage.setScene(new Scene(root));
            //primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.setTitle("Application");
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
