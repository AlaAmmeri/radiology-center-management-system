package entities;

public class CompteRendu {
    private int idCompteRendu;
    private int idMedecinRadiologue;
    private String contenu;
    private Type examen;
    private String date;
    public CompteRendu() {}
    public CompteRendu(int medecinRadiologue, String contenu, Type examen, String date) {
        this.idMedecinRadiologue = medecinRadiologue;
        this.contenu = contenu;
        this.examen = examen;
        this.date = date;
    }
    public int getIdCompteRendu() {
        return idCompteRendu;
    }
    public void setIdCompteRendu(int idCompteRendu) {
        this.idCompteRendu = idCompteRendu;
    }

    public void setIdMedecinRadiologue(int idMedecinRadiologue) {
        this.idMedecinRadiologue = idMedecinRadiologue;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setExamen(Type examen) {
        this.examen = examen;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdMedecinRadiologue() {
        return idMedecinRadiologue;
    }

    public String getContenu() {
        return contenu;
    }

    public Type getExamen() {
        return examen;
    }

    public String getDate() {
        return date;
    }
    public String toString() {
        return "Compte rendu: "+"\nid medecin radiologue: "+idMedecinRadiologue+"\ncontenue: "+contenu+"\nexamen: "+examen+"\ndate: "+date+"\n";
    }
}
