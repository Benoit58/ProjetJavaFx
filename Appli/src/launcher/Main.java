package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/views/mainWindow.fxml"));

        window = primaryStage;
        window.setTitle("JAVAFX - Project");
        window.show();
        window.setOnCloseRequest(event -> {
            event.consume();  //ctrl+Q to check the meaning of the method
            closeProgram();
        });

        BorderPane grid = new BorderPane();

        button = new Button("Quit");
        button.setOnAction(event -> closeProgram());

        Label randomText = new Label("QUITTER CETTE FENETRE");

        StackPane layout = new StackPane();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(button);

        Scene scene= new Scene(root, 300, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram(){
        Boolean answer = ConfirmBox.display("Title","Are you sure you want to exit ?");
        if(answer)
            window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
