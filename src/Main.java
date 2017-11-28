
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    Stage window;
    Button button;
    //Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("View/MainWindow.fxml"));

        //CREATE A SIMPLE BUTTON WHICH PRINT IN THE CONSOLE

        /*Button button;
        primaryStage.setTitle("My Window");
        button = new Button();
        button.setText("Click me");

        //This class will handle the button events  --> anonymous inner class
        //Just put the code between brackets
        button.setOnAction(e -> {
            System.out.println("1");
            System.out.println("2");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,250);
        primaryStage.setScene(scene);
        primaryStage.show();
        */

        //SWITCHING BETWEEN 2 SCENES
        window = primaryStage;

        /*Label label1 = new Label("This is the scene 1");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout 1 - children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1,button1);
        scene1 = new Scene(layout1,300,300);

        //Button 2
        Button button2 = new Button("Go back to scene 1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene1);*/

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
}
