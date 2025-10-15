package services;

import entities.*;
import reposetory.ReposetoryPatient;

public class ServicePatient {
    public static Patient[] readAll(){
        return ReposetoryPatient.readAllJSON();
    }
    public static Patient getPatientID(int id){
        return ReposetoryPatient.getPatientIDJSON(id);
    }
    public static DossierPatient getDossierPatientID(int id){
        return ReposetoryPatient.getDossierPatientIDJSON(id);
    }
    public static Ordonnance getOrdonnanceID(int id){
        return ReposetoryPatient.getOrdonnanceIDJSON(id);
    }
    public static Examen getExamenID(int id){
        return ReposetoryPatient.getExamenIDJSON(id);
    }
    public static CompteRendu getCompteRenduID(int id){
        return ReposetoryPatient.getCompteRenduIDJSON(id);
    }
    public static int generatePatientID(){
        return ReposetoryPatient.generatePatientIDJSON();
    }
    public static int generateDossierID(){
        return ReposetoryPatient.generateDossierIDJSON();
    }
    public static int generateOrdonnanceID(){
        return ReposetoryPatient.generateOrdonnanceIDJSON();
    }
    public static int generateExamenID(){
        return ReposetoryPatient.generateExamenIDJSON();
    }
    public static int generateCompteRenduID(){
        return ReposetoryPatient.generateCompteRenduIDJSON();
    }
    public static boolean removePatient(int id){
        return ReposetoryPatient.removePatient(id);
    }
    public static boolean removeOrdonnance(int id){
        return ReposetoryPatient.removeOrdonnance(id);
    }
    public static boolean modifierOrdonnance(int idOrd,Ordonnance ordonnance){
        return ReposetoryPatient.modifierOrdonnanceJSON(idOrd,ordonnance);
    }
    public static boolean removeExamen(int id){
        return ReposetoryPatient.removeExamen(id);
    }
    public static boolean removeCompteRendu(int id){
        return ReposetoryPatient.removeCompteRendu(id);
    }
    public static boolean modifierExamen(int id,Examen examen){
        return ReposetoryPatient.modifierExamenJSON(id,examen);
    }
    public static boolean modifierCompteRendu(int id,CompteRendu compteRendu){
        return ReposetoryPatient.modifierCompteRenduJSON(id,compteRendu);
    }
    public static boolean ajoutPatient(Patient p){
        return ReposetoryPatient.ajoutPatientJSON(p);
    }
    public static boolean ajoutIdDossier(int id,Patient p){
        return ReposetoryPatient.ajoutIdDossierJSON(id,p);
    }

}
