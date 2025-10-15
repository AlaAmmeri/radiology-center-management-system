package controller;

import entities.*;
import ihm.GestionPatientUI;
import services.ServicePatient;

public class ControllerPatient {
    public static void initController() {
        GestionPatientUI.initUI();
    }

    public static Patient[] afficherTous() {
            return ServicePatient.readAll();
    }
    public static void getFullInfoID(int id) {
        DossierPatient dossierPatient;
        Patient patient=ServicePatient.getPatientID(id);
        GestionPatientUI.afficherPatient(patient);
        for(int ID: patient.getIdsDossierPatients()) {
            System.out.println("ID dossier: "+ID);
            dossierPatient=ServicePatient.getDossierPatientID(ID);
            GestionPatientUI.afficherOrdonnance(ServicePatient.getOrdonnanceID(dossierPatient.getIdOrdonnance()));
            GestionPatientUI.afficherExamen(ServicePatient.getExamenID(dossierPatient.getIdExamen()));
            GestionPatientUI.afficherCompteRendu(ServicePatient.getCompteRenduID(dossierPatient.getIdCompteRendu()));
        }
    }
    public static boolean ajoutePatient() {
        try {
            Patient patient = GestionPatientUI.saisirPatient();
            patient.setId(ServicePatient.generatePatientID());
            ServicePatient.ajoutPatient(patient);
            Ordonnance ordonnance=GestionPatientUI.saisirOrdonnance();
            ordonnance.setIdOrdonnance(ServicePatient.generateOrdonnanceID());
            Examen examen=GestionPatientUI.saisirExamen();
            examen.setIdExamen(ServicePatient.generateExamenID());
            CompteRendu compteRendu=GestionPatientUI.saisirCompteRendu();
            compteRendu.setIdCompteRendu(ServicePatient.generateCompteRenduID());
            DossierPatient dossierPatient=new DossierPatient();
            dossierPatient.setDossierID(ServicePatient.generateDossierID());
            dossierPatient.setIdExamen(examen.getIdExamen());
            dossierPatient.setIdOrdonnance(ordonnance.getIdOrdonnance());
            dossierPatient.setIdCompteRendu(compteRendu.getIdCompteRendu());
            ServicePatient.ajoutIdDossier(dossierPatient.getDossierID(),patient);
            return true;
        }catch(Exception e) {
            return false;
        }

    }
    public static boolean removePatient(int id) {
        return ServicePatient.removePatient(id);
    }
    public static boolean removeOrdonnance(int idDossier) {
        return ServicePatient.removeOrdonnance(idDossier);
    }
    public static boolean modifierOrdonnance(int idDossier, Ordonnance ordonnance) {
        DossierPatient dossierPatient =ServicePatient.getDossierPatientID(idDossier);
        return ServicePatient.modifierOrdonnance(dossierPatient.getIdOrdonnance(),ordonnance);
    }
    public static boolean removeExamen(int idDossier) {
        return ServicePatient.removeExamen(idDossier);
    }
    public static boolean removeCompteRendu(int idDossier){
        return ServicePatient.removeCompteRendu(idDossier);
    }
    public static boolean modifierExamen(int idDossier, Examen examen) {
        return ServicePatient.modifierExamen(idDossier,examen);
    }
    public static boolean modifierCompteRendu(int idDossier, CompteRendu compteRendu) {
        return ServicePatient.modifierCompteRendu(idDossier,compteRendu);
    }

    public static String infoPatient(int id) {
        String result = "";
        DossierPatient dossierPatient;
        Patient patient=ServicePatient.getPatientID(id);
        GestionPatientUI.afficherPatient(patient);
        for(int ID: patient.getIdsDossierPatients()) {
            dossierPatient=ServicePatient.getDossierPatientID(ID);
            result+="ID dossier: "+ID+"\n"+ServicePatient.getOrdonnanceID(dossierPatient.getIdOrdonnance())+"\n"+ServicePatient.getExamenID(dossierPatient.getIdExamen())+"\n"+ServicePatient.getCompteRenduID(dossierPatient.getIdCompteRendu());
        }
        return result;
    }
}
