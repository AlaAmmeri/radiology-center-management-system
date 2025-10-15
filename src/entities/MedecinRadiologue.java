package entities;

public class MedecinRadiologue extends Employee{
    SpecialiteRadiologue specialite;

    public MedecinRadiologue(int ID, String nom, String prenom, int age,String sexe, String adresse, String email, int telephone,double salary, SpecialiteRadiologue specialite) {
        super(ID, nom, prenom, age,sexe, adresse, email, telephone,salary);
        this.specialite = specialite;
    }
    public MedecinRadiologue() {}
    public void setSpecialite(SpecialiteRadiologue specialite) {
        this.specialite = specialite;
    }
    public SpecialiteRadiologue getSpecialite() {
        return specialite;
    }
    public String toString() {
        return super.toString() + "\nspecialite: " + specialite ;
    }
}
