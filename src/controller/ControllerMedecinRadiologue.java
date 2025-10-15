package controller;

import entities.MedecinRadiologue;
import ihm.GestionRadiologueUI;
import services.ServiceMedecinRadiologue;

public class ControllerMedecinRadiologue {
    public static void initController() {
        // Initialize the UI
        GestionRadiologueUI.initUI();
    }

    public static MedecinRadiologue[] afficherTous() {
        // First, test if the saved file is not empty
        if (ServiceMedecinRadiologue.testNotNull()) {
            MedecinRadiologue[] medecinRadiologues = ServiceMedecinRadiologue.readAll();
            // Returns an array of objects
            return medecinRadiologues;
        } else {
            return null;
        }
    }

    public static boolean addMedecinRadiologue() {
        MedecinRadiologue m = GestionRadiologueUI.createMedecinRadiologue();
        return ServiceMedecinRadiologue.saveMedecinRadiologue(m);
    }

    public static boolean removeMedRadiologue() {
        int id = GestionRadiologueUI.initRemoveUI();
        return ServiceMedecinRadiologue.removeMedRadiologueID(id);
    }

    public static boolean modifierRadiologue(int id) {
        // Placeholder for modification functionality
        return true;
    }

    public static MedecinRadiologue getByID(int id) {
        return ServiceMedecinRadiologue.getByID(id);
    }
}
