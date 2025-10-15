package entities;

public class DossierPatient {
    private int dossierID;
    private int idOrdonnance;
    private int idCompteRendu;
    private int idExamen;
    public DossierPatient() {}

    public DossierPatient(int dossierID, int idOrdonnance, int idCompteRendu, int idExamen) {
        this.dossierID = dossierID;
        this.idOrdonnance = idOrdonnance;
        this.idCompteRendu = idCompteRendu;
        this.idExamen = idExamen;
    }

    public void setDossierID(int dossierID) {
        this.dossierID = dossierID;
    }

    public void setIdOrdonnance(int idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public void setIdCompteRendu(int idCompteRendu) {
        this.idCompteRendu = idCompteRendu;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public int getDossierID() {
        return dossierID;
    }

    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public int getIdCompteRendu() {
        return idCompteRendu;
    }

    public int getIdExamen() {
        return idExamen;
    }
}
