package gui;

import Quiz.HandleQuestions;
import Quiz.Question;
import Quiz.Timer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;

public class QuizController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private Button one,two,three,four;
    @FXML
    private ProgressBar progressBar;

    private ArrayList<Question> questions;
    private Question actualQuestion;
    private Timer timer;
    private boolean timeUp;

    @FXML
    public void handleButtonClicked(ActionEvent event) {
        if(!timeUp) {
            timer.interrupt();
            Button b = (Button) event.getSource();
            System.out.println(b.getText());
            if (b.getText().equals(actualQuestion.getCorrectAnswer())) {
                System.out.println("Correct");
                b.setId("correctAnswer");
            } else {
                b.setId("wrongAnswer");
            }
            System.out.println(timer.getUsedIterations());
            timer = new Timer(this);
            timer.waitForNextQuestion(10);
        }
    }

    public void setProgressBar(double progress){
        progressBar.setProgress(progress);
    }

    public void timeIsUp() {
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Quiz");
            a.setContentText("Die Zeit ist abgelaufen!");
            a.showAndWait();
            timeUp = true;
            timer = new Timer(this);
            timer.waitForNextQuestion(0);
        });
    }

    public void displayQuestion() {
        Platform.runLater(() -> {
            timeUp = false;
            progressBar.setProgress(1);
            if(questions.size()==0) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Quiz");
                a.setContentText("Du hast alle Fragen beantwortet!");
                a.show();
                return;
            }
            one.setId("options");
            two.setId("options");
            three.setId("options");
            four.setId("options");
            Random r = new Random();
            Question choosenQuestion = questions.get(r.nextInt(questions.size()));
            actualQuestion = choosenQuestion;
            ArrayList<String> answersList = new ArrayList<>();
            Collections.addAll(answersList, choosenQuestion.getWrongAnswers());
            answersList.add(choosenQuestion.getCorrectAnswer());
            Collections.shuffle(answersList);
            String[] answers = new String[4];
            answersList.toArray(answers);
            questions.remove(actualQuestion);
            question.setText(choosenQuestion.getQuestion());
            one.setText(answers[0]);
            two.setText(answers[1]);
            three.setText(answers[2]);
            four.setText(answers[3]);
            timer = new Timer(QuizController.this);
            timer.start();
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HandleQuestions hq = new HandleQuestions();
        questions = hq.loadQuestions();
        timer = new Timer(this);
        displayQuestion();
    }
}