package entities;

public class RendezVous {
    private int idRendezVous;
    private int idSalle;
    private String date;
    private int idPatient;
    private int idRadiologue;
    private int idTechnicien;
    private Type examenType;
    public RendezVous() {}
    public RendezVous(int idSalle, String date, int idPatient, int idRadiologue, int idTechnicien, Type examenType) {
        this.idSalle = idSalle;
        this.date = date;
        this.idRadiologue = idRadiologue;
        this.idTechnicien = idTechnicien;
        this.examenType = examenType;
        this.idPatient = idPatient;
    }
    public int getIdRendezVous() {
        return idRendezVous;
    }
    public void setIdRendezVous(int idRendezVous) {
        this.idRendezVous = idRendezVous;
    }
    public int getIdPatient(){
        return idPatient;
    }
    public void setIdPatient(int idPatient){
        this.idPatient = idPatient;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIdRadiologue(int idRadiologue) {
        this.idRadiologue = idRadiologue;
    }

    public void setIdTechnicien(int idTechnicien) {
        this.idTechnicien = idTechnicien;
    }

    public void setExamenType(Type examenType) {
        this.examenType = examenType;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public String getDate() {
        return date;
    }

    public int getIdRadiologue() {
        return idRadiologue;
    }

    public int getIdTechnicien() {
        return idTechnicien;
    }

    public Type getExamenType() {
        return examenType;
    }
    public String toString(){
        return "\nid rendez vous: "+idRendezVous +"\nid patient: "+idPatient+"\nDate: "+date+"\ntype examen: "+examenType+"\nid salle examen: "+idSalle+"\nid radiologue examen: "+idRadiologue+"\nid technicien examen: "+idTechnicien;
    }
}
