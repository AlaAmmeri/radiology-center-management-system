package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.MedecinPrescripteur;
import entities.SalleExamen;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReposetorySalleExamen {

    /**
     * returns the number of 'SalleExamen' objects save in the json file
     *
     * @return int
     */
    private static int fileLenght() {
        Gson gson = new Gson();
        FileReader reader = null;
        try {
            reader = new FileReader("src/reposetory/SalleExamen.json");
            MedecinPrescripteur[] tabPrescripteur = gson.fromJson(reader, MedecinPrescripteur[].class);
            return tabPrescripteur.length;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean testIDExists(int id) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/SalleExamen.json");
            Type salleListType = new TypeToken<ArrayList<SalleExamen>>() {
            }.getType();
            List<SalleExamen> listSalle = gson.fromJson(reader, salleListType);
            for (SalleExamen s : listSalle) {
                if (s.getId() == id) {
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            return false;
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
    public static SalleExamen[] afficherTousJSON(){
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/SalleExamen.json");
            SalleExamen[] salleExamen = gson.fromJson(reader,SalleExamen[].class);
            return salleExamen;

        }catch (FileNotFoundException e){
            return null;
        }

    }
    public static boolean addSalleJSON(SalleExamen salleExamen){
        salleExamen.setId(createIDJSON());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader= new FileReader("src/reposetory/SalleExamen.json");
            Type salleList = new TypeToken<ArrayList<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamenList = gson.fromJson(reader,salleList);
            salleExamenList.add(salleExamen);
            FileWriter writer= new FileWriter("src/reposetory/SalleExamen.json");
            gson.toJson(salleExamenList, writer);
            writer.close();
            return true;

        }catch(FileNotFoundException e){
            return false;
        }catch(IOException e){
            return false;
        }
    }
    public static int createIDJSON() {
        int id = 1;
        Gson gson = new Gson();
        if (!testNotNullJSON()) {
            //the first object takes the first id
            return 1;
        }
        try {
            FileReader reader = new FileReader("src/reposetory/SalleExamen.json");
            SalleExamen[] tabSalle = gson.fromJson(reader, SalleExamen[].class);
            //the way this generates th id is it check the last object added and adds 1 since the ids are in assendent order(this way there won't be any issues when removing an object)
            return tabSalle[tabSalle.length - 1].getId() + 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean suppSalleJSON(int id){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader= new FileReader("src/reposetory/SalleExamen.json");
            Type salleList = new TypeToken<ArrayList<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamenList = gson.fromJson(reader,salleList);
            for (SalleExamen s : salleExamenList) {
                if (s.getId() == id) {
                    salleExamenList.remove(s);
                }
            }
            FileWriter writer=new FileWriter("src/reposetory/SalleExamen.json");
            gson.toJson(salleExamenList, writer);
            writer.close();
            return true;

        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    /*public static boolean modifierSalleJSON(int id,SalleExamen salleExamen){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try{
            FileReader reader=new FileReader("src/reposetory/SalleExamen.json");
            Type salleList = new TypeToken<ArrayList<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamenList = gson.fromJson(reader,salleList);
            for (SalleExamen s : salleExamenList) {
                if (s.getId() == id) {
                    s.setExamen(salleExamen.getExamen());
                    s.setIsDiponible(salleExamen.getIsDiponible());
                    s.setEquipements(salleExamen.getEquipements());
                    return true;
                }
            }
            return false;
        }catch (FileNotFoundException e){
            return false;
        }
    }*/
    /*public static boolean setStatusJSON(int id,boolean status){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader=new FileReader("src/reposetory/SalleExamen.json");
            SalleExamen[] salle = new SalleExamen[]{gson.fromJson(reader, SalleExamen.class)};
            for (SalleExamen s : salle) {
                if (s.getId() == id) {
                    s.setIsDiponible(status);
                    return true;
                }
            }
            return false;
        }catch (FileNotFoundException e){
            return false;
        }
    }*/
}
