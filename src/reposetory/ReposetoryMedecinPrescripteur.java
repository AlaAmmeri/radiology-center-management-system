package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.MedecinPrescripteur;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class ReposetoryMedecinPrescripteur {
    /**
     * returns the number of 'MedecinPrescripteur' objects save in the json file
     *
     * @return int
     */
    private static int fileLenght() {
        Gson gson = new Gson();
        FileReader reader = null;
        try {
            reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            MedecinPrescripteur[] tabPrescripteur = gson.fromJson(reader, MedecinPrescripteur[].class);
            return tabPrescripteur.length;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * tests if the json file isn't empty
     *
     * @return boolean
     */
    public static boolean testNotNullJSON() {
        if (fileLenght() == 0) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * returns all objects saved in the json file and return them as an Array of 'MedecinPrescripteur'
     *
     * @return MedecinPrescripteur[]
     */
    public static MedecinPrescripteur[] readAllJSON() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            MedecinPrescripteur[] tabPrescripteur = gson.fromJson(reader, MedecinPrescripteur[].class);
            return tabPrescripteur;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * create a unique id
     *
     * @return int
     */
    public static int createIDJSON() {
        int id = 1;
        Gson gson = new Gson();
        if (!testNotNullJSON()) {
            //the first object takes the first id
            return 1;
        }
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            MedecinPrescripteur[] tabPrescripteur = gson.fromJson(reader, MedecinPrescripteur[].class);
            //the way this generates th id is it check the last object added and adds 1 since the ids are in assendent order(this way there won't be any issues when removing an object)
            return tabPrescripteur[tabPrescripteur.length - 1].getId() + 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves the object 'MedecinPrescripteur' to a json file
     *
     * @param Prescripteur
     * @return true if saved successfully else false
     */
    public static boolean saveMedecinPrescripteurJSON(MedecinPrescripteur Prescripteur) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            Type prescripteurList = new TypeToken<ArrayList<MedecinPrescripteur>>() {}.getType();
            List<MedecinPrescripteur> listPrescripteur = gson.fromJson(reader, prescripteurList);
            listPrescripteur.add(Prescripteur);

            FileWriter writer = new FileWriter("src/reposetory/MedecinPrescripteur.json");
            gson.toJson(listPrescripteur, writer);
            writer.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * tests if the corresponding id exists in the json file
     * @param id
     * @return boolean
     */

        public static boolean testIDExists(int id){
            Gson gson = new Gson();
            try {
                FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
                Type prescripteurList=new TypeToken<ArrayList<MedecinPrescripteur>>(){}.getType();
                List<MedecinPrescripteur> listPrescripteur=gson.fromJson(reader, prescripteurList);
                for(MedecinPrescripteur m : listPrescripteur){
                    if(m.getId() == id){
                        return true;
                    }
                }
                return true;
            } catch (FileNotFoundException e) {
                return false;
            }

        }

    /**
     * removes the med with the corresponding id
     * @param id
     * @return boolean
     */
    public static boolean removeMedPrescripteurJSON(int id){
            Gson gson = new Gson();
            try {
                //reads the file in a list
                FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
                Type prescripteurList=new TypeToken<ArrayList<MedecinPrescripteur>>(){}.getType();
                List<MedecinPrescripteur> listPrescripteur=gson.fromJson(reader, prescripteurList);
                for(MedecinPrescripteur m : listPrescripteur){
                    if(m.getId() == id){
                        //removes the med from the list
                        listPrescripteur.remove(m);
                        break;
                    }
                }
                //saves the modified list to the json file
                FileWriter writer = new FileWriter("src/reposetory/MedecinPrescripteur.json");
                gson.toJson(listPrescripteur, writer);
                writer.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        public static boolean setStatusJSON(int id,boolean status){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try {
                FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
                Type prescripteurList=new TypeToken<ArrayList<MedecinPrescripteur>>(){}.getType();
                List<MedecinPrescripteur> listPrescripteur=gson.fromJson(reader, prescripteurList);
                for(MedecinPrescripteur m : listPrescripteur){
                    if(m.getId() == id){
                        //m.setIsAvailable(status);
                        break;
                    }
                }
                return true;
            }catch (Exception e){
                return false;
            }
        }
        public static MedecinPrescripteur getByIDJSON(int id){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try {
                FileReader reader=new FileReader("src/reposetory/MedecinPrescripteur.json");
                MedecinPrescripteur[] tabPrescripteur = gson.fromJson(reader, MedecinPrescripteur[].class);
                for(MedecinPrescripteur m : tabPrescripteur){
                    if(m.getId() == id){
                        return m;
                    }
                }
                return null;

            } catch (FileNotFoundException e) {
                return null;
            }
        }
}
