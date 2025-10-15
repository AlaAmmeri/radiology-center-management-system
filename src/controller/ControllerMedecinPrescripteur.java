package controller;

import entities.MedecinPrescripteur;
import ihm.GestionPrescripteurUI;
import services.ServiceMedecinPrescripteur;

public class ControllerMedecinPrescripteur {
    public static void initController(){
        //initialize the IU
        GestionPrescripteurUI.initUI();
    }
    public static MedecinPrescripteur[] afficherTous(){
        //first testing if the saved file not empty
        if(ServiceMedecinPrescripteur.testNotNull()){
            MedecinPrescripteur[] medecinPrescripteurs= ServiceMedecinPrescripteur.readAll();
            //returns an array of objects
            return medecinPrescripteurs;
        }else{
            return null;
        }
    }
    public static boolean addMedecinPrescripteur(){
        MedecinPrescripteur m= GestionPrescripteurUI.createMedecinPrescripteur();
        return ServiceMedecinPrescripteur.saveMedecinPrescripteur(m);
    }
    public static boolean removeMedPrescripteur(){
        int id=GestionPrescripteurUI.initRemoveUI();
        return ServiceMedecinPrescripteur.removeMedPrescripteurID(id);
    }
    public static boolean modifierPrescripteur(int id){
        return true;
    }
    public static MedecinPrescripteur getByID(int id){
        return ServiceMedecinPrescripteur.getByID(id);
    }
}
