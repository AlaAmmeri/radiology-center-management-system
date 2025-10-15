package controller;

import entities.SalleExamen;
import ihm.GestionSalleUI;
import services.ServiceSalleExamen;

public class ControllerSalle {
    public static void initController(){
        GestionSalleUI.initUI();
    }
    public static SalleExamen[] afficher(){
        return ServiceSalleExamen.afficherTous();
    }
    public static boolean addSalle(){
        SalleExamen s= GestionSalleUI.addSalle();
        return ServiceSalleExamen.addSalles(s);
    }
    public static boolean suppSalle(){
        int id=GestionSalleUI.getIDSalle();
        return ServiceSalleExamen.supprimerSalle(id);
    }
    public static void modifierSalle(){
        GestionSalleUI.modifierSalleUI();
    }
    /*public static boolean modifierSalleID(int id,SalleExamen salleExamen){
        return ServiceSalleExamen.modifierSalle(id,salleExamen);
    }*/
    //public static void modifierStatus(int id,boolean status){}
}
