package controller;

import business_logic.sensor.ISensor;
import business_logic.sensor.SensorsManager;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.*;

public class ISensorCell2 extends ListCell<ISensor> {
    public ISensorCell2(){

        setOnDragEntered((DragEvent event) -> {
            setStyle("-fx-background-color: grey;");
        });

        setOnDragExited((DragEvent event) -> {
            setStyle("");
        });

        setOnDragOver((DragEvent event) -> {
            if (event.getDragboard().hasString())
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            event.consume();
        });

        setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            boolean success = false;

            if (db.hasString() && SensorsManager.getSelectedSensor() != null && getItem() != SensorsManager.getSelectedSensor()) {
                System.out.println(SensorsManager.getSelectedSensor());
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });
    }

    @Override
    protected void updateItem(ISensor item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
        }
        else
            setText(item.getSensorName());
    }
}
