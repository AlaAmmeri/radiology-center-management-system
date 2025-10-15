package controller;

import entities.RendezVous;
import entities.Type;
import ihm.GestionRendezVousUI;
import services.ServiceRendezVous;

import java.util.List;

public class ControllerRendezVous {
    public static void initController() {
        GestionRendezVousUI.initUI();
    }
    public static List<RendezVous> obtenirTous(){
        return ServiceRendezVous.obtenirTous();
    }
    public static RendezVous getRendezVousID(int id){
        return ServiceRendezVous.getRendezVousID(id);
    }
    public static void ajouterRendezVous(){
        RendezVous rendezVous= GestionRendezVousUI.createRendezVous();
        ServiceRendezVous.saveRendezVous(rendezVous);
    }

    public static boolean checkSalleType(Type examenType, int idSalle) {
        return ServiceRendezVous.checkSalleType(examenType,idSalle);
    }

    public static boolean checkDateSalle(String date, int idSalle) {
        return ServiceRendezVous.checkDateSalle(date,idSalle);
    }

    public static void reserverSalle(String date, int idSalle) {
        ServiceRendezVous.reserverSalle(date,idSalle);
    }

    public static boolean checkDateRadiologue(String date, int idRadiologue) {
        return ServiceRendezVous.checkDateRadiologue(date,idRadiologue);
    }


    public static void reserverRadiologue(String date, int idRadiologue) {
        ServiceRendezVous.reserverRadiologue(date,idRadiologue);
    }

    public static boolean checkDateTechnicien(String date, int idTechnicien) {
        return ServiceRendezVous.checkDateTechnicien(date,idTechnicien);
    }

    public static void reserverTechnicien(String date, int idTechnicien) {
        ServiceRendezVous.reserverTechnicien(date,idTechnicien);
    }

    public static int generateID() {
        return ServiceRendezVous.generateID();
    }

    public static boolean deleteRendezVous(int idRendezVous) {
        return ServiceRendezVous.deleteRendezVous(idRendezVous);
    }
}
