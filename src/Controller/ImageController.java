package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageController {

    @FXML
    private ImageView imageToModify;

    @FXML
    private void changePhoto(ActionEvent event){
          //code du bouton
        imageToModify.setImage(new Image("image/soundsystem.jpg"));

    }


}
