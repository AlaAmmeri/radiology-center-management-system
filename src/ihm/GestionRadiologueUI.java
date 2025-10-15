package ihm;

import controller.ControllerMedecinRadiologue;
import entities.MedecinRadiologue;
import entities.SpecialiteRadiologue;

import java.util.Scanner;

public class GestionRadiologueUI {
    public static void initUI() {
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        int id;
        MedecinRadiologue[] m;
        MedecinRadiologue med;
        do {
            System.out.println("1) Afficher tous les médecins radiologues");
            System.out.println("2) Ajouter un médecin radiologue");
            System.out.println("3) Supprimer un médecin radiologue");
            System.out.println("4) Modifier un médecin radiologue (not functional yet :/)");
            System.out.println("5) Afficher par ID");
            System.out.println("6) Quitter");
            switch (sc.nextInt()) {
                case 1:
                    m = ControllerMedecinRadiologue.afficherTous();
                    if (m == null) {
                        System.out.println("Erreur 404");
                    } else {
                        for (MedecinRadiologue mr : m) {
                            System.out.println(mr);
                        }
                    }
                    break;
                case 2:
                    if (ControllerMedecinRadiologue.addMedecinRadiologue()) {
                        System.out.println("Radiologue ajouté avec succès !");
                    } else {
                        System.out.println("Erreur d'ajout");
                    }
                    break;
                case 3:
                    if (!ControllerMedecinRadiologue.removeMedRadiologue()) {
                        System.out.println("Erreur ou ID non existant");
                    } else {
                        System.out.println("Médecin radiologue supprimé avec succès");
                    }
                    break;
                case 4:
                    System.out.println("Saisir l'ID");
                    id = sc.nextInt();
                    System.out.println("1) Modifier tout");
                    switch (sc.nextInt()) {
                        case 1:
                            ControllerMedecinRadiologue.modifierRadiologue(id);
                            break;
                        default:
                            System.out.println("Option invalide");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Saisir l'ID : ");
                    id = sc.nextInt();
                    med = ControllerMedecinRadiologue.getByID(id);
                    if (med == null) {
                        System.out.println("Erreur ou ID non existant");
                    } else {
                        System.out.println(med);
                    }
                    break;
                case 6:
                    quit = false;
                    break;
            }
        } while (quit);
    }

    public static MedecinRadiologue createMedecinRadiologue() {
        MedecinRadiologue med = new MedecinRadiologue();
        Scanner sc = new Scanner(System.in);
        med.setId(-1);
        med.setUnavailableDates(null);
        System.out.println("Donner le nom : ");
        med.setNom(sc.nextLine());
        System.out.println("Donner le prénom : ");
        med.setPrenom(sc.nextLine());
        System.out.println("Donner l'âge : ");
        med.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner le sexe : ");
        med.setSexe(sc.nextLine());
        System.out.println("Donner l'adresse : ");
        med.setAdresse(sc.nextLine());
        System.out.println("Donner le téléphone : ");
        med.setTelephone(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner l'email : ");
        med.setEmail(sc.nextLine());
        System.out.println("Donner le salaire : ");
        med.setSalary(sc.nextDouble());
        sc.nextLine();
        System.out.println("Donner la spécialité : ");
        String input = sc.nextLine().toUpperCase();
        try {
            SpecialiteRadiologue specialite = SpecialiteRadiologue.valueOf(input);
            med.setSpecialite(specialite);
        } catch (IllegalArgumentException e) {
            System.out.println("Entrée invalide. Veuillez choisir parmi les spécialités listées.");
            med.setSpecialite(null);
        }
        return med;
    }
    public static int initRemoveUI(){
        System.out.println("Write the corresponding ID: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
