package controller;

import entities.Technicien;
import ihm.GestionTechnicienUI;
import services.ServiceTechnicien;

public class ControllerTechnicien {
    public static void initController() {
        GestionTechnicienUI.initUI();
    }

    public static Technicien[] afficherTous() {
        if (ServiceTechnicien.testNotNull()) {
            return ServiceTechnicien.readAll();
        } else {
            return null;
        }
    }

    public static boolean addTechnicien() {
        Technicien tech = GestionTechnicienUI.createTechnicien();
        return ServiceTechnicien.saveTechnicien(tech);
    }

    public static boolean removeTechnicien() {
        int id = GestionTechnicienUI.initRemoveUI();
        return ServiceTechnicien.removeTechnicienID(id);
    }

    public static boolean modifierTechnicien(int id) {
        // Add modification logic if needed
        return true;
    }

    public static Technicien getByID(int id) {
        return ServiceTechnicien.getByID(id);
    }
}
