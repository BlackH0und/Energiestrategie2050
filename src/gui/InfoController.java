package gui;

import informations.HandleInformations;
import informations.Information;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    @FXML
    public void handleButtonBack(ActionEvent e) {
        showInfos();
    }

    public void showInfos() {
        Button back = new Button("Zurück");
        contentBox.setAlignment(Pos.CENTER);
        back.setOnAction(e -> showInfos());
        back.setTranslateX(20);
        back.setTranslateY(20);
        contentBox.getChildren().removeAll(contentBox.getChildren());
        contentBox.setSpacing(5);
        for (Information i : infos) {
            Button b = new Button(i.getTitle());
            b.setPrefWidth(500);
            b.setPrefHeight(50);
            b.setId("titleButton");
            b.setOnAction(e -> {
                contentBox.getChildren().removeAll(contentBox.getChildren());
                contentBox.setAlignment(Pos.TOP_LEFT);
                Label text = new Label(i.getText());
                text.setWrapText(true);
                text.setTranslateX(20);
                text.setPadding(new Insets(0, 40, 0, 0));
                text.setTranslateY(20);
                contentBox.getChildren().add(back);
                contentBox.setSpacing(20);
                contentBox.getChildren().add(text);
            });
            contentBox.getChildren().add(b);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HandleInformations  hi = new HandleInformations();
        contentBox.setId("contentBox");
        infos = hi.loadInformations();
        showInfos();
    }
}
