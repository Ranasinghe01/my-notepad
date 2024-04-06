package lk.ijse.dep12.my_notepad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL resource = getClass().getResource("/view/MainView.fxml");
        AnchorPane controller = FXMLLoader.load(resource);
        Scene mainScene = new Scene(controller);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Untitled Document - Notepad");
        primaryStage.centerOnScreen();
        primaryStage.show();


    }
}
