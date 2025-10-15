package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class ReposetoryPatient {
    public static Patient[] readAllJSON(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("src/reposetory/Patient.json");
            Patient[] patients = gson.fromJson(reader, Patient[].class);
            return patients;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    public static Patient getPatientIDJSON(int id){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("src/reposetory/Patient.json");
            Patient[] patients = gson.fromJson(reader, Patient[].class);
            for (Patient patient : patients) {
                if (patient.getId() == id) {
                    return patient;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    public static DossierPatient getDossierPatientIDJSON(int id){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("src/reposetory/DossierPatient.json");
            DossierPatient[] dossierPatients = gson.fromJson(reader, DossierPatient[].class);
            for(DossierPatient dossier : dossierPatients) {
                if (dossier.getDossierID() == id) {
                    return dossier;
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
    public static Ordonnance getOrdonnanceIDJSON(int id){
        try{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileReader reader= new FileReader("src/reposetory/Ordonnance.json");
        Ordonnance[] ordonnances = gson.fromJson(reader, Ordonnance[].class);
        for(Ordonnance ordonnance : ordonnances) {
            if(ordonnance.getIdOrdonnance() == id) {
                return ordonnance;
            }
        }
        return null;
        }catch (FileNotFoundException e){
            return null;
        }
    }
    public static Examen getExamenIDJSON(int id){
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader= new FileReader("src/reposetory/Examen.json");
            Examen[] examens = gson.fromJson(reader, Examen[].class);
            for(Examen examen : examens) {
                if(examen.getIdExamen() == id) {
                    return examen;
                }
            }
            return null;
        }catch (FileNotFoundException e){
            return null;
        }
    }
    public static CompteRendu getCompteRenduIDJSON(int id){
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader=new FileReader("src/reposetory/CompteRendu.json");
            CompteRendu[] compteRendus= gson.fromJson(reader, CompteRendu[].class);
            for(CompteRendu compteRendu : compteRendus) {
                if(compteRendu.getIdCompteRendu() == id) {
                    return compteRendu;
                }
            }
            return null;
        }catch (FileNotFoundException e){
            return null;
        }
    }
    public static int generatePatientIDJSON(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("src/reposetory/Patient.json");
            Patient[] patients = gson.fromJson(reader, Patient[].class);
            return patients[patients.length-1].getId()+1;
        } catch (FileNotFoundException e) {
            return 1;
        }
    }
    public static int generateDossierIDJSON(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("src/reposetory/DossierPatient.json");
            DossierPatient[] dossierPatients = gson.fromJson(reader, DossierPatient[].class);
            return dossierPatients[dossierPatients.length-1].getDossierID()+1;
        }catch (FileNotFoundException e){
            return 1;
        }
    }
    public static int generateCompteRenduIDJSON(){
        try {
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            FileReader reader= new FileReader("src/reposetory/CompteRendu.json");
            CompteRendu[] compteRendus = gson.fromJson(reader, CompteRendu[].class);
            return compteRendus[compteRendus.length-1].getIdCompteRendu()+1;
        }catch (FileNotFoundException e){
            return 1;
        }
    }
    public static int generateOrdonnanceIDJSON(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader=new FileReader("src/reposetory/Ordonnance.json");
            Ordonnance[] ordonnances = gson.fromJson(reader, Ordonnance[].class);
            return ordonnances[ordonnances.length-1].getIdOrdonnance()+1;
        }catch (FileNotFoundException e){
            return -1;
        }
    }
    public static int generateExamenIDJSON(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader=new FileReader("src/reposetory/Examen.json");
            Examen[] examens = gson.fromJson(reader, Examen[].class);
            return examens[examens.length-1].getIdExamen()+1;
        }catch (FileNotFoundException e){
            return -1;
        }
    }
    public static boolean removeExamen(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Examen.json");
            Type examenType = new TypeToken<List<Examen>>() {}.getType();
            List<Examen> examens = gson.fromJson(reader, examenType);

            Iterator<Examen> iterator = examens.iterator();
            while (iterator.hasNext()) {
                Examen examen = iterator.next();
                if (examen.getIdExamen() == id) {
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/Examen.json");
            gson.toJson(examens, examenType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean removeOrdonnance(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Ordonnance.json");
            Type ordonnanceType = new TypeToken<List<Ordonnance>>() {}.getType();
            List<Ordonnance> ordonnances = gson.fromJson(reader, ordonnanceType);

            Iterator<Ordonnance> iterator = ordonnances.iterator();
            while (iterator.hasNext()) {
                Ordonnance ordonnance = iterator.next();
                if (ordonnance.getIdOrdonnance() == id) {
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/Ordonnance.json");
            gson.toJson(ordonnances, ordonnanceType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeCompteRendu(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/CompteRendu.json");
            Type compteType = new TypeToken<List<CompteRendu>>() {}.getType();
            List<CompteRendu> compteRendus = gson.fromJson(reader, compteType);

            Iterator<CompteRendu> iterator = compteRendus.iterator();
            while (iterator.hasNext()) {
                CompteRendu compteRendu = iterator.next();
                if (compteRendu.getIdCompteRendu() == id) {
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/CompteRendu.json");
            gson.toJson(compteRendus, compteType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removeDossier(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/DossierPatient.json");
            Type dossierType = new TypeToken<List<DossierPatient>>() {}.getType();
            List<DossierPatient> dossiers = gson.fromJson(reader, dossierType);

            Iterator<DossierPatient> iterator = dossiers.iterator();
            while (iterator.hasNext()) {
                DossierPatient dossierPatient = iterator.next();
                if (dossierPatient.getDossierID() == id) {
                    removeExamen(dossierPatient.getIdExamen());
                    removeCompteRendu(dossierPatient.getIdCompteRendu());
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/DossierPatient.json");
            gson.toJson(dossiers, dossierType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean removePatient(int id) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Patient.json");
            Type patientType = new TypeToken<List<Patient>>() {}.getType();
            List<Patient> patients = gson.fromJson(reader, patientType);

            Iterator<Patient> iterator = patients.iterator();
            while (iterator.hasNext()) {
                Patient patient = iterator.next();
                if (patient.getId() == id) {
                    if (patient.getIdsDossierPatients() != null) {
                        for (int ids : patient.getIdsDossierPatients()) {
                            removeDossier(ids);
                        }
                    }
                    iterator.remove();
                    break;
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/Patient.json");
            gson.toJson(patients, patientType, writer);
            writer.close();
            reader.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean modifierOrdonnanceJSON(int id,Ordonnance ordonnance){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/Ordonnance.json");
            Type ordonnanceType = new TypeToken<Ordonnance>() {}.getType();
            List<Ordonnance> ordonnances=gson.fromJson(reader,ordonnanceType);
            for (Ordonnance ord : ordonnances) {
                if(ord.getIdOrdonnance() == id){
                    ord.setDate(ordonnance.getDate());
                    ord.setTypeExamen(ordonnance.getTypeExamen());
                    ord.setMedecinPrescripteur(ordonnance.getMedecinPrescripteur());
                    ord.setContenu(ordonnance.getContenu());
                }
            }
            FileWriter writer=new FileWriter("src/reposetory/Ordonnance.json");
            gson.toJson(ordonnances, ordonnanceType, writer);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean modifierExamenJSON(int id, Examen examen) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Examen.json");
            Type examenType = new TypeToken<List<Examen>>() {}.getType();
            List<Examen> examens = gson.fromJson(reader, examenType);

            for (Examen ex : examens) {
                if (ex.getIdExamen() == id) {
                    ex.setDate(examen.getDate());
                    ex.setType(examen.getType());
                    ex.setPrix(examen.getPrix());
                    ex.setResult(examen.getResult());
                    ex.setIdSalle(examen.getIdSalle());
                    ex.setIdTechnicien(examen.getIdTechnicien());
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/Examen.json");
            gson.toJson(examens, examenType, writer);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean modifierCompteRenduJSON(int id, CompteRendu compteRendu) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/CompteRendu.json");
            Type compteRenduType = new TypeToken<List<CompteRendu>>() {}.getType();
            List<CompteRendu> comptesRendus = gson.fromJson(reader, compteRenduType);

            for (CompteRendu cr : comptesRendus) {
                if (cr.getIdCompteRendu() == id) {
                    cr.setDate(compteRendu.getDate());
                    cr.setContenu(compteRendu.getContenu());
                    cr.setExamen(compteRendu.getExamen());
                    cr.setIdMedecinRadiologue(compteRendu.getIdMedecinRadiologue());
                }
            }

            FileWriter writer = new FileWriter("src/reposetory/CompteRendu.json");
            gson.toJson(comptesRendus, compteRenduType, writer);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean ajoutPatientJSON(Patient p) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Patient.json");
            Type patientType = new TypeToken<List<Patient>>() {
            }.getType();
            List<Patient> patients = gson.fromJson(reader, patientType);
            patients.add(p);
            FileWriter writer = new FileWriter("src/reposetory/Patient.json");
            gson.toJson(patients, patientType, writer);
            writer.close();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public static boolean ajoutIdDossierJSON(int id, Patient p){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader =new FileReader("src/reposetory/Patient.json");
            Type patientType = new TypeToken<List<Patient>>() {}.getType();
            List<Patient> patients = gson.fromJson(reader, patientType);
            for (Patient pt : patients) {
                if (pt.getId()==p.getId()){
                    List<Integer> ids =pt.getIdsDossierPatients();
                    ids.add(id);
                    pt.setIdsDossierPatients(ids);
                }
            }
            FileWriter writer = new FileWriter("src/reposetory/Patient.json");
            gson.toJson(patients, patientType, writer);
            writer.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
