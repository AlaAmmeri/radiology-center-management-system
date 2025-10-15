package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReposetoryRendezVous {
    public static List<RendezVous> obtenirTousJSON(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader=new FileReader("src/reposetory/RendezVous.json");
            Type rendezVousType = new TypeToken<List<RendezVous>>() {}.getType();
            List<RendezVous> rendezVous = gson.fromJson(reader,rendezVousType);
            return rendezVous;
        }catch (FileNotFoundException e){
            return null;
        }
    }
    public static RendezVous getRendezVousIDJSON(int id){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader=new FileReader("src/reposetory/RendezVous.json");
            Type rendezVousType = new TypeToken<List<RendezVous>>() {}.getType();
            List<RendezVous> rendezVous = gson.fromJson(reader,rendezVousType);
            for (RendezVous r:rendezVous){
                if (r.getIdPatient() == id){
                    return r;
                }
            }
            return null;
        }catch (FileNotFoundException e){
            return null;
        }
    }

    public static boolean checkSalleType(entities.Type examenType, int idSalle) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/SalleExamen.json");
            Type salleType = new TypeToken<List<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamen = gson.fromJson(reader,salleType);
            for (SalleExamen s:salleExamen){
                if (s.getId() == idSalle){
                    if(s.getExamen() == examenType){
                        return true;
                    }
                }
            }
            return false;
        }catch (FileNotFoundException e){
            return false;
        }
    }

    public static boolean checkDateSalle(String date, int idSalle) {
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/SalleExamen.json");
            Type salleType = new TypeToken<List<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamen = gson.fromJson(reader,salleType);
            for (SalleExamen s:salleExamen){
                if (s.getId() == idSalle){
                    if(s.getExamen() == null){
                        return true;
                    }else {
                        for (String dateReserve:s.getUnavailableDates()){
                            if (dateReserve.equals(date)){
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void reserverSalle(String date, int id) {
        List<String> dates=new ArrayList<>();
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/SalleExamen.json");
            Type salleType = new TypeToken<List<SalleExamen>>() {}.getType();
            List<SalleExamen> salleExamen = gson.fromJson(reader,salleType);
            for (SalleExamen s:salleExamen){
                if (s.getId() == id){
                    dates = s.getUnavailableDates();
                    dates.add(date);
                    s.setUnavailableDates(dates);
                    break;
                }
            }
            FileWriter writer=new FileWriter("src/reposetory/SalleExamen.json");
            gson.toJson(dates,writer);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkDateRadiologue(String date, int idRadiologue) {
        Gson gson =new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/MedecinRadiologue.json");
            Type radiologueType = new TypeToken<List<MedecinRadiologue>>() {}.getType();
            List<MedecinRadiologue> radiologues = gson.fromJson(reader,radiologueType);
            for (MedecinRadiologue s:radiologues){
                if (s.getId() == idRadiologue){
                    if(s.getUnavailableDates() == null){
                        return true;
                    }else {
                        for (String dateReserve:s.getUnavailableDates()){
                            if (dateReserve.equals(date)){
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkDateMedecinPrescripteur(String date, int idMedecinPrescripteur) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            Type medecinPrescripteurType = new TypeToken<List<MedecinPrescripteur>>() {}.getType();
            List<MedecinPrescripteur> medecinPrescripteurs = gson.fromJson(reader, medecinPrescripteurType);
            for (MedecinPrescripteur s : medecinPrescripteurs) {
                if (s.getId() == idMedecinPrescripteur) {
                    if (s.getUnavailableDates() == null) {
                        return true;
                    } else {
                        for (String dateReserve : s.getUnavailableDates()) {
                            if (dateReserve.equals(date)) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkDateTechnicien(String date, int idTechnicien) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicienType = new TypeToken<List<Technicien>>() {}.getType();
            List<Technicien> techniciens = gson.fromJson(reader, technicienType);
            for (Technicien s : techniciens) {
                if (s.getId() == idTechnicien) {
                    if (s.getUnavailableDates() == null) {
                        return true;
                    } else {
                        for (String dateReserve : s.getUnavailableDates()) {
                            if (dateReserve.equals(date)) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    public static void reserverMedecinRadiologue(String date, int id) {
        List<String> dates = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinRadiologue.json");
            Type medecinType = new TypeToken<List<MedecinRadiologue>>() {}.getType();
            List<MedecinRadiologue> medecinRadiologues = gson.fromJson(reader, medecinType);
            for (MedecinRadiologue s : medecinRadiologues) {
                if (s.getId() == id) {
                    dates = s.getUnavailableDates();
                    if (dates == null) {
                        dates = new ArrayList<>();
                    }
                    dates.add(date);
                    s.setUnavailableDates(dates);
                    break;
                }
            }
            FileWriter writer = new FileWriter("src/reposetory/MedecinRadiologue.json");
            gson.toJson(medecinRadiologues, medecinType, writer);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void reserverMedecinPrescripteur(String date, int id) {
        List<String> dates = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/MedecinPrescripteur.json");
            Type medecinType = new TypeToken<List<MedecinPrescripteur>>() {}.getType();
            List<MedecinPrescripteur> medecinPrescripteurs = gson.fromJson(reader, medecinType);
            for (MedecinPrescripteur s : medecinPrescripteurs) {
                if (s.getId() == id) {
                    dates = s.getUnavailableDates();
                    if (dates == null) {
                        dates = new ArrayList<>();
                    }
                    dates.add(date);
                    s.setUnavailableDates(dates);
                    break;
                }
            }
            FileWriter writer = new FileWriter("src/reposetory/MedecinPrescripteur.json");
            gson.toJson(medecinPrescripteurs, medecinType, writer);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void reserverTechnicien(String date, int id) {
        List<String> dates = new ArrayList<>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Technicien.json");
            Type technicienType = new TypeToken<List<Technicien>>() {}.getType();
            List<Technicien> techniciens = gson.fromJson(reader, technicienType);
            for (Technicien s : techniciens) {
                if (s.getId() == id) {
                    dates = s.getUnavailableDates();
                    if (dates == null) {
                        dates = new ArrayList<>();
                    }
                    dates.add(date);
                    s.setUnavailableDates(dates);
                    break;
                }
            }
            FileWriter writer = new FileWriter("src/reposetory/Technicien.json");
            gson.toJson(techniciens, technicienType, writer);
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int generateID() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader=new FileReader("src/reposetory/RendezVous.json");
            RendezVous[] rendezVousses = gson.fromJson(reader, RendezVous[].class);
            return rendezVousses[rendezVousses.length-1].getIdRendezVous()+1;
        } catch (Exception e) {
            return 1;
        }

    }

    public static void saveRendezVous(RendezVous rendezVous) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader=new FileReader("src/reposetory/RendezVous.json");
            Type rendezVousType = new TypeToken<List<RendezVous>>() {}.getType();
            List<RendezVous> rendezVouss = gson.fromJson(reader,rendezVousType);
            rendezVouss.add(rendezVous);
            FileWriter writer =new FileWriter("src/reposetory/RendezVous.json");
            gson.toJson(rendezVouss, rendezVousType, writer);
            writer.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteRendezVous(int idRendezVous) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/RendezVous.json");
            Type rendezVousType = new TypeToken<List<RendezVous>>() {}.getType();
            List<RendezVous> rendezVouss = gson.fromJson(reader, rendezVousType);

            Iterator<RendezVous> iterator = rendezVouss.iterator();
            while (iterator.hasNext()) {
                RendezVous r = iterator.next();
                if (r.getIdRendezVous() == idRendezVous) {
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/RendezVous.json");
            gson.toJson(rendezVouss, rendezVousType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
