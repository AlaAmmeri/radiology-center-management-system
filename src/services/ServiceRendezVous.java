package services;

import entities.RendezVous;
import entities.Type;
import reposetory.ReposetoryRendezVous;

import java.util.List;

public class ServiceRendezVous {
    public static List<RendezVous> obtenirTous(){
        return ReposetoryRendezVous.obtenirTousJSON();
    }
    public static RendezVous getRendezVousID(int id){
        return ReposetoryRendezVous.getRendezVousIDJSON(id);
    }

    public static boolean checkSalleType(Type examenType, int idSalle) {
        return ReposetoryRendezVous.checkSalleType(examenType,idSalle);
    }

    public static boolean checkDateSalle(String date, int idSalle) {
        return ReposetoryRendezVous.checkDateSalle(date,idSalle);
    }

    public static void reserverSalle(String date,int id) {
        ReposetoryRendezVous.reserverSalle(date,id);

    }

    public static boolean checkDateRadiologue(String date, int idRadiologue) {
        return ReposetoryRendezVous.checkDateRadiologue(date,idRadiologue);
    }

    public static boolean checkDatePrescripteur(String date, int idPrescripteur) {
        return ReposetoryRendezVous.checkDateMedecinPrescripteur(date,idPrescripteur);
    }

    public static void reserverRadiologue(String date, int idRadiologue) {
        ReposetoryRendezVous.reserverMedecinRadiologue(date,idRadiologue);
    }

    public static boolean checkDateTechnicien(String date, int idTechnicien) {
        return ReposetoryRendezVous.checkDateTechnicien(date,idTechnicien);
    }
    public static void reserverTechnicien(String date, int idTechnicien) {
        ReposetoryRendezVous.reserverTechnicien(date,idTechnicien);
    }

    public static int generateID() {
        return ReposetoryRendezVous.generateID();
    }

    public static void saveRendezVous(RendezVous rendezVous) {
        ReposetoryRendezVous.saveRendezVous(rendezVous);
    }

    public static boolean deleteRendezVous(int idRendezVous) {
        return ReposetoryRendezVous.deleteRendezVous(idRendezVous);
    }
}
