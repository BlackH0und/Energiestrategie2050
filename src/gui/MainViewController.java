package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Stage primaryStage;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Button infoButton, quizButton;

    @FXML
    public void minimize() {
        primaryStage.setIconified(true);
    }

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public void handleButtonInfo(ActionEvent e) {
        infoButton.setId("active");
        quizButton.setId("");
        try {
            contentPane.getChildren().remove(0);
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InfoGui.fxml"));
            contentPane.getChildren().add(newLoadedPane);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    public void handleButtonQuiz(ActionEvent e) {
        quizButton.setId("active");
        infoButton.setId("");
        try {
            contentPane.getChildren().remove(0);
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("QuizGui.fxml"));
            contentPane.getChildren().add(newLoadedPane);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InfoGui.fxml"));
            contentPane.getChildren().add(newLoadedPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
}