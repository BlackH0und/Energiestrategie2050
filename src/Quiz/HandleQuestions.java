package Quiz;


import java.io.*;
import java.util.ArrayList;

public class HandleQuestions {

    private File data = new File("questions.txt");

    public ArrayList<Question> loadQuestions(){
        if(data.exists()) {
            try {
                ArrayList<Question> questions = new ArrayList<>();
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(data));
                String fileContent = "";
                while(reader.available()>0){
                    fileContent += (char)reader.read();
                }
                String[] lines = fileContent.split("\n");
                System.out.println("Es wurden " + lines.length + " Fragen geladen.");
                for(String line : lines){
                    String[] questionparts = line.split(";");
                    questions.add(new Question(questionparts[0], questionparts[1], new String[]{questionparts[2],questionparts[3], questionparts[4]}));
                    //System.out.println(questionparts[0] + "\n" + questionparts[1] + "\n" + questionparts[2] + "\n" + questionparts[3] + "\n" + questionparts[4] + "\n");
                }
                return questions;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
