package lk.ijse.dep12.my_notepad.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainViewController {
    public AnchorPane root;
    public MenuItem btnExit;
    public MenuItem btnNew;

    public void AboutOnAction(ActionEvent actionEvent) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/AboutView.fxml")));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(mainScene);
    }

    public void CloseOnAction(ActionEvent actionEvent) {
        ((Stage) root.getScene().getWindow()).close();
    }

    public void ExitOnAction(ActionEvent actionEvent) {
        ((Stage) root.getScene().getWindow()).close();
    }

    public void NewOnAction(ActionEvent actionEvent) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
        Stage stage = new Stage();
        stage.setScene(mainScene);
        stage.show();
        stage.centerOnScreen();
    }
}
