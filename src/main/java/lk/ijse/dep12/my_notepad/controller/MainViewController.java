package lk.ijse.dep12.my_notepad.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainViewController {

    public AnchorPane root;
    public MenuItem btnExit;
    public MenuItem btnNew;
    public TextArea txtArea;
    public MenuItem btnSave;
    public MenuItem btnSaveAs;
    public MenuItem btnOpen;
    public MenuItem btnNewWindow;

    private File currentFile;

    public void AboutOnAction(ActionEvent actionEvent) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/AboutView.fxml")));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(mainScene);
    }

    public void mnuExitOnAction(ActionEvent actionEvent) {
        ((Stage) root.getScene().getWindow()).close();
    }

    public void mnuNewOnAction(ActionEvent actionEvent) throws IOException {
        currentFile = null;
        setTitle("Untitled Document");
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(mainScene);
    }

    private void setTitle(String title) {
        ((Stage) (txtArea.getScene().getWindow())).setTitle(title);
    }

    public void mnuNewWindowOnAction(ActionEvent actionEvent) throws IOException {
        Scene mainScene = new Scene(FXMLLoader.load(getClass().getResource("/view/MainView.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Untitled Document - Notepad");
        stage.setScene(mainScene);
        stage.show();
        stage.centerOnScreen();
    }

    public void mnuSaveOnAction(ActionEvent actionEvent) throws IOException{

        if (currentFile != null) {
            String content = txtArea.getText();
            File file = new File(String.valueOf(currentFile));

            try(FileOutputStream fos = new FileOutputStream(file)) {
                char[] chars = content.toCharArray();
                for (char c : chars) {
                    fos.write(c);
                }
            }
        }
    }

    public void mnuSaveAsOnAction(ActionEvent actionEvent) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Folder to Save");
        File file = fileChooser.showSaveDialog(root.getScene().getWindow());
        if (file == null) {
            System.out.println("No FOlder Selected");

        } else {

            String content = txtArea.getText();
            File file1 = new File(String.valueOf(file));
            file1.createNewFile();

            try(FileOutputStream fos = new FileOutputStream(file1)) {
                char[] chars = content.toCharArray();
                for (char c : chars) {
                    fos.write(c);
                }
            }
            currentFile = file;
            setTitle(currentFile.getName());
        }
    }
    public void mnuOpenOnAction(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a text file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Plain Text Files (*.txt)", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files(*.*)", "*.*"));
        fileChooser.setInitialDirectory(new File(System.getenv("HOME"), "Downloads"));
        currentFile = fileChooser.showOpenDialog(txtArea.getScene().getWindow());

        if (currentFile == null) return;

        try{
            try(FileInputStream fis = new FileInputStream(currentFile)) {
                byte[] bytes = new byte[(int) currentFile.length()];
                fis.read(bytes);
                txtArea.setText(new String(bytes));
                setTitle(currentFile.getName());
            }

        } catch (Throwable e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to read the file, try again");
            alert.show();
            e.printStackTrace();
        }
    }
}
