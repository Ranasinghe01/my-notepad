package lk.ijse.dep12.my_notepad.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutViewController {
    public AnchorPane root;

    public void GoBackOnAction(ActionEvent actionEvent) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(mainScene);
    }
}
