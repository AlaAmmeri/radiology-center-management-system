package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Technicien;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReposetoryTechnicien {
    public static boolean testNotNullJSON() {
        return fileLength() > 0;
    }

    private static int fileLength() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Technicien[] technicians = gson.fromJson(reader, Technicien[].class);
            return technicians.length;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Technicien[] readAllJSON() {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            return gson.fromJson(reader, Technicien[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int createIDJSON() {
        if (!testNotNullJSON()) return 1;
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Technicien[] technicians = gson.fromJson(reader, Technicien[].class);
            return technicians[technicians.length - 1].getId() + 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean saveTechnicienJSON(Technicien tech) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicianListType = new TypeToken<ArrayList<Technicien>>() {}.getType();
            List<Technicien> technicians = gson.fromJson(reader, technicianListType);
            technicians.add(tech);

            FileWriter writer = new FileWriter("src/reposetory/Technicien.json");
            gson.toJson(technicians, writer);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testIDExists(int id) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicianListType = new TypeToken<ArrayList<Technicien>>() {}.getType();
            List<Technicien> technicians = gson.fromJson(reader, technicianListType);
            return technicians.stream().anyMatch(t -> t.getId() == id);
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public static boolean removeTechnicienJSON(int id) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicianListType = new TypeToken<ArrayList<Technicien>>() {}.getType();
            List<Technicien> technicians = gson.fromJson(reader, technicianListType);

            List<Technicien> updatedTechnicians = new ArrayList<>();
            for (Technicien tech : technicians) {
                if (tech.getId() != id) {
                    updatedTechnicians.add(tech);
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/Technicien.json");
            gson.toJson(updatedTechnicians, writer);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Technicien getByIDJSON(int id) {
        Gson gson = new Gson();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicianListType = new TypeToken<ArrayList<Technicien>>() {}.getType();
            List<Technicien> technicians = gson.fromJson(reader, technicianListType);
            return technicians.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}
