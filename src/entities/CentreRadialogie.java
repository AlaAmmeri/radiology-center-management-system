package entities;

import java.util.ArrayList;
import java.util.List;

public class CentreRadialogie {
    private int id;
    private InformationCentre informationCentre;
    private Finance finance;
    private int nbMedpres,nbMedRad,nbPat,nbTech;
    private List<MedecinRadiologue> listRadiologues=new ArrayList<>();
    private List<MedecinPrescripteur> listPrescripteur=new ArrayList<>();
    private List<Patient> listPatient=new ArrayList<>();
    private List<Technicien> listTechnicien=new ArrayList<>();

    public CentreRadialogie(int id, InformationCentre informationCentre, Finance finance, int nbMedpres, int nbMedRad, int nbPat, int nbTech, List<MedecinRadiologue> listRadiologues, List<MedecinPrescripteur> listPrescripteur, List<Patient> listPatient, List<Technicien> listTechnicien) {
        this.id = id;
        this.informationCentre = informationCentre;
        this.finance = finance;
        this.nbMedpres = nbMedpres;
        this.nbMedRad = nbMedRad;
        this.nbPat = nbPat;
        this.nbTech = nbTech;
        this.listRadiologues = listRadiologues;
        this.listPrescripteur = listPrescripteur;
        this.listPatient = listPatient;
        this.listTechnicien = listTechnicien;
    }

    public int getId() {
        return id;
    }

    public InformationCentre getInformationCentre() {
        return informationCentre;
    }

    public Finance getFinance() {
        return finance;
    }

    public int getNbMedpres() {
        return nbMedpres;
    }

    public int getNbMedRad() {
        return nbMedRad;
    }

    public int getNbPat() {
        return nbPat;
    }

    public int getNbTech() {
        return nbTech;
    }

    public List<MedecinRadiologue> getListRadiologues() {
        return listRadiologues;
    }

    public List<MedecinPrescripteur> getListPrescripteur() {
        return listPrescripteur;
    }

    public List<Patient> getListPatient() {
        return listPatient;
    }

    public List<Technicien> getListTechnicien() {
        return listTechnicien;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInformationCentre(InformationCentre informationCentre) {
        this.informationCentre = informationCentre;
    }

    public void setFinance(Finance finance) {
        this.finance = finance;
    }

    public void setNbMedpres(int nbMedpres) {
        this.nbMedpres = nbMedpres;
    }

    public void setNbMedRad(int nbMedRad) {
        this.nbMedRad = nbMedRad;
    }

    public void setNbPat(int nbPat) {
        this.nbPat = nbPat;
    }

    public void setNbTech(int nbTech) {
        this.nbTech = nbTech;
    }

    public void setListRadiologues(List<MedecinRadiologue> listRadiologues) {
        this.listRadiologues = listRadiologues;
    }

    public void setListPrescripteur(List<MedecinPrescripteur> listPrescripteur) {
        this.listPrescripteur = listPrescripteur;
    }

    public void setListPatient(List<Patient> listPatient) {
        this.listPatient = listPatient;
    }

    public void setListTechnicien(List<Technicien> listTechnicien) {
        this.listTechnicien = listTechnicien;
    }
}
