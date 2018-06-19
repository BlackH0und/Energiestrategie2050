package informations;

import java.io.*;
import java.util.ArrayList;

public class HandleInformations {

    private File file;

    public HandleInformations(){
        file = new File("informations.dat");
    }

    public ArrayList<Information> loadInformations(){
        if(file.exists()){
            try {
                ArrayList<Information> informations = new ArrayList<>();
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
                String fileContent = "";
                while(reader.available()>0){
                    fileContent += (char)reader.read();
                }
                String[] lines = fileContent.split("\n");
                for(String line : lines){
                    String[] information = line.split(";");
                    informations.add(new Information(information[0],information[1]));
                }
                return informations;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
