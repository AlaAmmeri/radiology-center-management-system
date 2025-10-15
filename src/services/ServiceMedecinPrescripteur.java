package services;

import entities.MedecinPrescripteur;
import reposetory.ReposetoryMedecinPrescripteur;

public class ServiceMedecinPrescripteur {
    public static boolean testNotNull(){
        return ReposetoryMedecinPrescripteur.testNotNullJSON();
    }
    public static MedecinPrescripteur[] readAll(){
        return ReposetoryMedecinPrescripteur.readAllJSON();
    }
    public static boolean saveMedecinPrescripteur(MedecinPrescripteur m){
        int id=ReposetoryMedecinPrescripteur.createIDJSON();
        m.setId(id);
        return ReposetoryMedecinPrescripteur.saveMedecinPrescripteurJSON(m);
    }
    public static boolean removeMedPrescripteurID(int id){
        if(!ReposetoryMedecinPrescripteur.testIDExists(id)){
            return false;
        }else{
            return ReposetoryMedecinPrescripteur.removeMedPrescripteurJSON(id);
        }
    }
    public static MedecinPrescripteur getByID(int id){
        if(!ReposetoryMedecinPrescripteur.testIDExists(id)){
            return null;
        }else {
            return ReposetoryMedecinPrescripteur.getByIDJSON(id);
        }
    }
}
