package entities;

public class Technicien extends Employee {
    private SpecialiteTechnicien specialite;
    public Technicien() {}

    public Technicien(int ID, String nom, String prenom, int age,String sexe, String adresse, String email, int telephone, double salary, SpecialiteTechnicien specialite) {
        super(ID, nom, prenom, age,sexe, adresse, email, telephone, salary);
        this.specialite = specialite;
    }
    public SpecialiteTechnicien getSpecialite() {
        return specialite;
    }
    public void setSpecialite(SpecialiteTechnicien specialite) {
        this.specialite = specialite;
    }
    public String toString(){
        return super.toString()+ "\nspecialite: " + specialite;
    }
}
