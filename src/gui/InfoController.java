package gui;

import informations.HandleInformations;
import informations.Information;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InfoController implements Initializable {

    private ArrayList<Information> infos;

    @FXML
    private VBox contentBox;

    public void showInfos(){
        contentBox.getChildren().removeAll(contentBox.getChildren());
        Button back = new Button("Back");
        back.setOnAction(e -> showInfos());
        for (Information i : infos) {
            Button b = new Button(i.getTitle());
            b.setPrefWidth(500);
            b.setPrefHeight(50);
            b.setId("titleButton");
            b.setOnAction(e -> {
                contentBox.getChildren().removeAll(contentBox.getChildren());
                contentBox.getChildren().add(back);
                Label text = new Label(i.getText());
                text.setWrapText(true);
                contentBox.getChildren().add(text);
            });
            contentBox.getChildren().add(b);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HandleInformations  hi = new HandleInformations();
        infos = hi.loadInformations();
        showInfos();
    }
}
