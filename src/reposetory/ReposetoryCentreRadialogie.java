package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.InformationCentre;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class ReposetoryCentreRadialogie {
    /**
     * takes a 'InformationCentre' object and saves it to json file
     * @param informationCentre
     * @return true if saved successfully, false if not
     */
    public static boolean saveInformationJSON(InformationCentre informationCentre){

        //returns True if saved successfully else false

        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("src/reposetory/InformationCentreRadialogieJSON.json");
            gson.toJson(informationCentre, writer);
            writer.close();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    /**
     * Checks the existence of information and returns them
     * @return 'InformationCentre' object or null
     */
    public static InformationCentre readInformationJSON(){
        // reads the info and returns it as 'InformationCentre' object else return null!
        Gson gson=new Gson();
        try {
            FileReader reader=new FileReader("src/reposetory/InformationCentreRadialogieJSON.json");
            InformationCentre informationCentre=gson.fromJson(reader,InformationCentre.class);
            return informationCentre;
        } catch (FileNotFoundException e) {
            return null;
        }

    }
}
