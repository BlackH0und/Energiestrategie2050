package gui;

import Quiz.HandleQuestions;
import Quiz.Question;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResourceAsStream("QuizGui.fxml"));
        root.getStylesheets().add(String.valueOf(getClass().getResource("QuizCSS.css")));
        primaryStage.setTitle("Quiz");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        HandleQuestions hq = new HandleQuestions();
        ArrayList<Question> questions = hq.loadQuestions();
        QuizController c = (QuizController) loader.getController();
        c.setQuestions(questions);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
