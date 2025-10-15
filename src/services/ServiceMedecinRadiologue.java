package services;

import entities.MedecinRadiologue;
import reposetory.ReposetoryMedecinRadiologue;

public class ServiceMedecinRadiologue {
    public static boolean testNotNull() {
        return ReposetoryMedecinRadiologue.testNotNullJSON();
    }

    public static MedecinRadiologue[] readAll() {
        return ReposetoryMedecinRadiologue.readAllJSON();
    }

    public static boolean saveMedecinRadiologue(MedecinRadiologue m) {
        int id = ReposetoryMedecinRadiologue.createIDJSON();
        m.setId(id);
        return ReposetoryMedecinRadiologue.saveMedecinRadiologueJSON(m);
    }

    public static boolean removeMedRadiologueID(int id) {
        if (!ReposetoryMedecinRadiologue.testIDExists(id)) {
            return false;
        } else {
            return ReposetoryMedecinRadiologue.removeMedRadiologueJSON(id);
        }
    }

    public static MedecinRadiologue getByID(int id) {
        if (!ReposetoryMedecinRadiologue.testIDExists(id)) {
            return null;
        } else {
            return ReposetoryMedecinRadiologue.getByIDJSON(id);
        }
    }
}
