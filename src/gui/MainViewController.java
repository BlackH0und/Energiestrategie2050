package gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Button infoButton, quizButton;

    @FXML
    public void minimize() {
        // TODO: Add Logic for Minimize-Button
    }

    @FXML
    public void close() {
        Platform.exit();
    }

    @FXML
    public void handleButtonInfo(ActionEvent e) {
        infoButton.setId("active");
        quizButton.setId("");
        // TODO: Add Logic to switch content

        try {
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
        // TODO: Add Logic to switch content
        try {
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("QuizGui.fxml"));
            contentPane.getChildren().add(newLoadedPane);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}