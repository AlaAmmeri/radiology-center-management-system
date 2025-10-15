package services;

import entities.SalleExamen;
import reposetory.ReposetorySalleExamen;

public class ServiceSalleExamen {
    public static SalleExamen[] afficherTous(){
        return ReposetorySalleExamen.afficherTousJSON();
    }
    public static boolean addSalles(SalleExamen salle){
        return ReposetorySalleExamen.addSalleJSON(salle);
    }
    public static boolean supprimerSalle(int id){
        if(ReposetorySalleExamen.testIDExists(id)){
            return ReposetorySalleExamen.suppSalleJSON(id);
        }else{
            return false;
        }
    }
    /*public static boolean modifierSalle(int id,SalleExamen salle){
        if(ReposetorySalleExamen.testIDExists(id)){
            return ReposetorySalleExamen.modifierSalleJSON(id,salle);
        }else{
            return false;
        }
    }*/
    /*public static boolean setStatus(int id,boolean status){
        if(ReposetorySalleExamen.testIDExists(id)){
            return ReposetorySalleExamen.setStatusJSON(id,status);
        }else {
            return false;
        }
    }*/
}
