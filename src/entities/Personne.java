package entities;

public class Personne {
    private int ID;
    private String nom;
    private String prenom;
    private String sexe;
    private int age;
    private String adresse;
    private String email;
    private int telephone;
    public Personne() {}
    public Personne(int ID, String nom, String prenom, int age,String sexe, String adresse, String email, int telephone){
        this.ID = ID;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.age = age;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public int getId() {
        return ID;
    }
    public void setId(int ID) {
        this.ID = ID;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getTelephone() {
        return telephone;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public String toString(){
        return "ID: "+ID+"\nName: "+nom+"\nlastname: "+prenom+"\nAge: "+age+"\nSexe: "+sexe+ "\nAdress: "+adresse+"\nEmail: "+email+"\nTelephone: "+telephone;
    }
}
