package entities;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Personne {
    private List<Integer> idsDossierPatients;
    public Patient() {
        super();
        idsDossierPatients = new ArrayList<>();
    }

    public Patient(int ID, String nom, String prenom, int age, String sexe, String adresse, String email, int telephone, List<Integer> idsDossierPatients) {
        super(ID, nom, prenom, age, sexe, adresse, email, telephone);
        this.idsDossierPatients = idsDossierPatients;
    }
    public List<Integer> getIdsDossierPatients() {
        return idsDossierPatients;
    }
    public void setIdsDossierPatients(List<Integer> idsDossierPatients) {
        this.idsDossierPatients = idsDossierPatients;
    }
}