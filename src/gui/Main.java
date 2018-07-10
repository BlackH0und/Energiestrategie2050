package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("MainGui.fxml"));
        root.getStylesheets().add(String.valueOf(getClass().getResource("MainStyle.css")));
        MainViewController mainViewController = (MainViewController)loader.getController();
        mainViewController.setPrimaryStage(primaryStage);
        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Quiz");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
