package entities;

public class MedecinPrescripteur extends Employee {
    private SpecialitePrescripteur specialite;

    public MedecinPrescripteur() {}

    public MedecinPrescripteur(int ID, String nom, String prenom, int age, String sexe, String adresse, String email, int telephone, double salary, SpecialitePrescripteur specialite) {
        super(ID, nom, prenom, age, sexe, adresse, email, telephone, salary); // Removed isAvailable
        this.specialite = specialite;
    }

    public SpecialitePrescripteur getSpecialite() {
        return specialite;
    }

    public void setSpecialite(SpecialitePrescripteur specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpecialite: " + specialite + "\n\n";
    }
}
