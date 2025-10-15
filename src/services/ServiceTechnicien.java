package services;

import entities.Technicien;
import reposetory.ReposetoryTechnicien;

public class ServiceTechnicien {
    public static boolean testNotNull() {
        return ReposetoryTechnicien.testNotNullJSON();
    }

    public static Technicien[] readAll() {
        return ReposetoryTechnicien.readAllJSON();
    }

    public static boolean saveTechnicien(Technicien tech) {
        int id = ReposetoryTechnicien.createIDJSON();
        tech.setId(id);
        return ReposetoryTechnicien.saveTechnicienJSON(tech);
    }

    public static boolean removeTechnicienID(int id) {
        if (!ReposetoryTechnicien.testIDExists(id)) {
            return false;
        } else {
            return ReposetoryTechnicien.removeTechnicienJSON(id);
        }
    }

    public static Technicien getByID(int id) {
        if (!ReposetoryTechnicien.testIDExists(id)) {
            return null;
        } else {
            return ReposetoryTechnicien.getByIDJSON(id);
        }
    }
}
