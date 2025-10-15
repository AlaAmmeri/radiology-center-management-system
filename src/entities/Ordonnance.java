package entities;

public class Ordonnance {
    int idOrdonnance;
    private int idMedecinPrescripteur;
    private String contenu;
    private Type typeExamen;
    private String date;
    public Ordonnance() {}
    public Ordonnance(int med, String cont, String d, Type t) {
        this.idMedecinPrescripteur = med;
        this.contenu = cont;
        this.typeExamen = t;
        this.date = d;
    }
    public int getIdOrdonnance() {
        return idOrdonnance;
    }
    public void setIdOrdonnance(int idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }
    public String toString(){
        return "Ordonnance: "+"\nid medecin prescripteur: "+idMedecinPrescripteur+"\ncontenu: "+contenu+"\ntype examen: "+typeExamen;
    }

    public void setMedecinPrescripteur(int medecinPrescripteur) {
        this.idMedecinPrescripteur = medecinPrescripteur;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTypeExamen(Type typeExamen) {
        this.typeExamen = typeExamen;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMedecinPrescripteur() {
        return idMedecinPrescripteur;
    }

    public String getContenu() {
        return contenu;
    }

    public Type getTypeExamen() {
        return typeExamen;
    }

    public String getDate() {
        return date;
    }
}
