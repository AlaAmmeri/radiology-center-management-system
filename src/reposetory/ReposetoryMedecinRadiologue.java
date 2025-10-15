package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.MedecinRadiologue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReposetoryMedecinRadiologue {
    private static int fileLength() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            MedecinRadiologue[] tabRadiologue = gson.fromJson(reader, MedecinRadiologue[].class);
            return tabRadiologue.length;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean testNotNullJSON() {
        return fileLength() != 0;
    }

    public static MedecinRadiologue[] readAllJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            return gson.fromJson(reader, MedecinRadiologue[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int createIDJSON() {
        if (!testNotNullJSON()) {
            return 1; // First object takes the first ID
        }
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            MedecinRadiologue[] tabRadiologue = gson.fromJson(reader, MedecinRadiologue[].class);
            return tabRadiologue[tabRadiologue.length - 1].getId() + 1;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean saveMedecinRadiologueJSON(MedecinRadiologue radiologue) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            Type radiologueList = new TypeToken<ArrayList<MedecinRadiologue>>() {}.getType();
            List<MedecinRadiologue> listRadiologue = gson.fromJson(reader, radiologueList);
            listRadiologue.add(radiologue);

            try (FileWriter writer = new FileWriter("src/reposetory/MedecinRadiologue.json")) {
                gson.toJson(listRadiologue, writer);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testIDExists(int id) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            Type radiologueList = new TypeToken<ArrayList<MedecinRadiologue>>() {}.getType();
            List<MedecinRadiologue> listRadiologue = gson.fromJson(reader, radiologueList);
            for (MedecinRadiologue m : listRadiologue) {
                if (m.getId() == id) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean removeMedRadiologueJSON(int id) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            Type radiologueList = new TypeToken<ArrayList<MedecinRadiologue>>() {}.getType();
            List<MedecinRadiologue> listRadiologue = gson.fromJson(reader, radiologueList);

            listRadiologue.removeIf(m -> m.getId() == id);

            try (FileWriter writer = new FileWriter("src/reposetory/MedecinRadiologue.json")) {
                gson.toJson(listRadiologue, writer);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static MedecinRadiologue getByIDJSON(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json")) {
            MedecinRadiologue[] tabRadiologue = gson.fromJson(reader, MedecinRadiologue[].class);
            for (MedecinRadiologue m : tabRadiologue) {
                if (m.getId() == id) {
                    return m;
                }
            }
            return null;
        }catch (IOException e) {
            return null;
        }
    }
}
