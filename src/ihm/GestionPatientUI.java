package ihm;

import controller.ControllerPatient;
import entities.*;

import javax.swing.text.Document;
import java.awt.*;
import java.io.FileOutputStream;
import java.util.Scanner;

public class GestionPatientUI {
    public static void initUI() {
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        boolean quit2 = true;
        int id;
        Patient[] patients;
        Patient patient;
        int idDossier;
        Ordonnance ordonnance;
        Examen examen;
        CompteRendu compteRendu;
        String sh;
        do {
            System.out.println("***********************************************************************");
            System.out.println("1) Afficher tous les patients");
            System.out.println("2) Ajouter un patient");
            System.out.println("3) Supprimer un patient");
            System.out.println("4) Modifier un patient");
            System.out.println("5) Afficher un patient par ID avec son dossier medical");
            System.out.println("6) sauvegaurd compte rendu sure pdf (suivant id patien)");
            System.out.println("7) Quitter");
            System.out.println("***********************************************************************");
            switch (sc.nextInt()) {
                case 1:
                    patients=ControllerPatient.afficherTous();
                    if(patients!=null) {
                        for (Patient p : patients) {
                            System.out.println(p);
                        }
                    }else{
                        System.out.println("Patient n'existe pas");
                    }
                    break;
                case 2:
                    if(ControllerPatient.ajoutePatient()){
                        System.out.println("Ajouter un patient avec succes");
                    }else{
                        System.out.println("erreur");
                    }
                    break;
                case 3:
                    System.out.println("Saisir l'id de patient");
                    id = sc.nextInt();
                    if (ControllerPatient.removePatient(id)) {
                        System.out.println("removed successfully!");
                    }else {
                        System.out.println("Patient n'existe pas");
                    }
                    break;
                case 4:

                    System.out.println("Saisir l'ID de dossier de ce patient: ");
                    idDossier =sc.nextInt();
                    sc.nextLine();

                    do {
                        System.out.println("***********************************************************************");
                        System.out.println("en train do modifier le Dossier ID: "+idDossier);
                        System.out.println("1) supprimer Ordonnance");
                        System.out.println("2) modifier Ordonnance");
                        System.out.println("3) supprimer Examen");
                        System.out.println("4) modifier Examen");
                        System.out.println("5) supprimer Compte Rendu");
                        System.out.println("6) modifier Compte Rendu");
                        System.out.println("7)Quitter");
                        System.out.println("***********************************************************************");
                        switch (sc.nextInt()){
                            case 1:
                                if(ControllerPatient.removeOrdonnance(idDossier)){
                                    System.out.println("removed successfully!");
                                }else {
                                    System.out.println("Error occured or there's no Ordonnance");
                                }
                                break;
                            case 2:
                                ordonnance= saisirOrdonnance();
                                if(ControllerPatient.modifierOrdonnance(idDossier,ordonnance)){
                                    System.out.println("modified successfully!");
                                }else {
                                    System.out.println("Error occured");
                                }
                                break;
                            case 3:
                                if (ControllerPatient.removeExamen(idDossier)){
                                    System.out.println("removed successfully!");
                                }else{
                                    System.out.println("Error occured");
                                }
                                break;
                            case 4:
                                examen= saisirExamen();
                                if (ControllerPatient.modifierExamen(idDossier,examen)){
                                    System.out.println("modified successfully!");
                                }else {
                                    System.out.println("Error occured");
                                }
                                break;
                            case 5:
                                if (ControllerPatient.removeCompteRendu(idDossier)){
                                    System.out.println("removed successfully!");
                                }else{
                                    System.out.println("Error occured");
                                }
                                break;
                            case 6:
                                compteRendu= saisirCompteRendu();
                                if(ControllerPatient.modifierCompteRendu(idDossier,compteRendu)){
                                    System.out.println("modified successfully!");
                                }else{
                                    System.out.println("Error occured");
                                }
                                break;
                            case 7:
                                quit2=false;
                                break;
                                default:
                                    System.out.println("Option invalide");
                                    break;

                        }
                    }while (quit2);

                    break;
                case 5:
                    System.out.println("Saisir l'ID: ");
                    id = sc.nextInt();
                    sh=ControllerPatient.infoPatient(id);
                    System.out.println(sh);

                    /*
                    Document document = new Document();
                    PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

                    document.open();
                    Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
                    Chunk chunk = new Chunk(sh, font);

                    document.add(chunk);
                    document.close();
                    */

                    break;
                case 6:
                    System.out.println("Saisir l'ID: ");
                    id = sc.nextInt();
                    ControllerPatient.getFullInfoID(id);


                    break;
                case 7:
                    quit = false;
                    break;
                default:
                    System.out.println("Option invalide");
                    break;
            }
        } while (quit);
    }
    public static void afficherPatient(Patient patient) {
        if (patient != null) {
            System.out.println(patient);
        }else {
            System.out.println("Patient n'existe pas");
        }
    }
    public static void afficherOrdonnance(Ordonnance ord) {
        if (ord != null) {
            System.out.println(ord);
        }else{
            System.out.println("Ordonnance n'existe pas");
        }
    }
    public static void afficherExamen(Examen exam) {
        if (exam != null) {
            System.out.println(exam);
        }else{
            System.out.println("Examen n'existe pas");
        }
    }
    public static void afficherCompteRendu(CompteRendu compte) {
        if (compte != null) {
            System.out.println(compte);
        }else{
            System.out.println("Compte n'existe pas");
        }
    }

    public static Patient saisirPatient() {  // Updated method name
        Patient p = new Patient();  // Updated type to Patient
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le nom: ");
        p.setNom(sc.nextLine());
        System.out.println("Donner le prénom: ");
        p.setPrenom(sc.nextLine());
        System.out.println("Donner l'âge: ");
        p.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner le sexe: ");
        p.setSexe(sc.nextLine());
        System.out.println("Donner l'adresse: ");
        p.setAdresse(sc.nextLine());
        System.out.println("Donner le téléphone: ");
        p.setTelephone(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner l'email: ");
        p.setEmail(sc.nextLine());
        return p;
    }
    public static Examen saisirExamen() {
        Examen exam = new Examen();
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le type d'examen: ");
        String input = sc.nextLine().toUpperCase();
        try {
            Type examen = Type.valueOf(input);
            exam.setType(examen);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please choose from the listed specialities.");
        }
        System.out.println("Donner le resultat: ");
        exam.setResult(sc.nextLine());
        System.out.println("Donner id technicien: ");
        exam.setIdTechnicien(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner le prix d'examen: ");
        exam.setPrix(sc.nextDouble());
        sc.nextLine();
        System.out.println("Donner la date d'examen (format: yyyy-MM-dd/HH:mm:ss): ");
        exam.setDate(sc.nextLine());
        return exam;
    }
    public static CompteRendu saisirCompteRendu(){
        CompteRendu compte = new CompteRendu();
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner le type d'examen: ");
        String input = sc.nextLine().toUpperCase();
        try{
            Type examen = Type.valueOf(input);
            compte.setExamen(examen);
        }catch (IllegalArgumentException e){
            System.out.println("Invalid input. Please choose from the listed specialities.");
        }
        System.out.println("Donner le contenu: ");
        compte.setContenu(sc.nextLine());
        System.out.println("Donner id medecin Radiologue: ");
        compte.setIdMedecinRadiologue(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner la date de creation (format: yyyy-MM-dd/HH:mm:ss): ");
        compte.setDate(sc.nextLine());
        return compte;
    }
    public static Ordonnance saisirOrdonnance() {
        Ordonnance ord = new Ordonnance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner l'id de medecin prescripteur: ");
        ord.setMedecinPrescripteur(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner le contenu d'ordonnance: ");
        ord.setContenu(sc.nextLine());
        System.out.println("Donner le type d'examen dans cet ordonnance: ");
        String input = sc.nextLine().toUpperCase();
        try {
            Type examen = Type.valueOf(input);
            ord.setTypeExamen(examen);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please choose from the listed specialities.");
        }
        System.out.println("Donner la date d'examen (format: yyyy-MM-dd/HH:mm:ss): ");
        ord.setDate(sc.nextLine());


        // Return the populated ordonnance object
        return ord;
    }


    public static int initRemoveUI() {
        System.out.println("Écrire l'ID correspondant: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int saisirID() {
        System.out.println("Écrire l'ID correspondant: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }
}
