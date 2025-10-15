package entities;

public class Examen {
    private Type type;
    private int idExamen;
    private String date;
    private String Result;
    private int idTechnicien;
    private int idSalle;
    private double prix;
    public Examen() {}

    public Examen(Type type, int idExamen, int idSalle, String date, String result, int technicien, double prix) {
        this.type = type;
        this.idExamen = idExamen;
        this.date = date;
        Result = result;
        this.idTechnicien = technicien;
        this.prix = prix;
        this.idSalle = idSalle;
    }
    public String toString(){
        return "Examen: "+"\nid examen: "+ idExamen +"\ntype examen: "+type+"\nid salle examen: "+idSalle+"\nid technicien: "+idTechnicien+"\ndate examen: "+date+"\nresult examen: "+Result+"\nprix examen: "+prix;
    }
    public int getIdSalle(){
        return idSalle;
    }
    public void setIdSalle(int idSalle){
        this.idSalle = idSalle;
    }

    public Type getType() {
        return type;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public String getDate() {
        return date;
    }

    public String getResult() {
        return Result;
    }

    public int getIdTechnicien() {
        return idTechnicien;
    }

    public double getPrix() {
        return prix;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResult(String result) {
        Result = result;
    }

    public void setIdTechnicien(int idTechnicien) {
        this.idTechnicien = idTechnicien;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
