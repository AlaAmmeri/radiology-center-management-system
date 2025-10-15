package ihm;

import controller.ControllerTechnicien;
import entities.SpecialiteTechnicien;
import entities.Technicien;

import java.util.Scanner;

public class GestionTechnicienUI {
    public static void initUI() {
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        int id;
        Technicien[] technicians;
        Technicien technician;
        do {
            System.out.println("1) Afficher tous les techniciens");
            System.out.println("2) Ajouter un technicien");
            System.out.println("3) Supprimer un technicien");
            System.out.println("4) Modifier un technicien (not implemented yet)");
            System.out.println("5) Afficher un technicien par ID");
            System.out.println("6) Quitter");
            switch (sc.nextInt()) {
                case 1:
                    technicians = ControllerTechnicien.afficherTous();
                    if (technicians == null) {
                        System.out.println("Erreur 404");
                    } else {
                        for (Technicien t : technicians) {
                            System.out.println(t);
                        }
                    }
                    break;
                case 2:
                    if (ControllerTechnicien.addTechnicien()) {
                        System.out.println("Technicien ajouté avec succès!");
                    } else {
                        System.out.println("Erreur d'ajout");
                    }
                    break;
                case 3:
                    if (!ControllerTechnicien.removeTechnicien()) {
                        System.out.println("Erreur ou ID inexistant");
                    } else {
                        System.out.println("Technicien supprimé avec succès");
                    }
                    break;
                case 4:
                    System.out.println("Saisir l'ID");
                    id = sc.nextInt();
                    ControllerTechnicien.modifierTechnicien(id);
                    break;
                case 5:
                    System.out.println("Saisir l'ID: ");
                    id = sc.nextInt();
                    technician = ControllerTechnicien.getByID(id);
                    if (technician == null) {
                        System.out.println("Erreur ou ID inexistant");
                    } else {
                        System.out.println(technician);
                    }
                    break;
                case 6:
                    quit = false;
                    break;
                default:
                    System.out.println("Option invalide");
                    break;
            }
        } while (quit);
    }

    public static Technicien createTechnicien() {
        Technicien tech = new Technicien();
        Scanner sc = new Scanner(System.in);
        tech.setId(-1);
        tech.setUnavailableDates(null);
        System.out.println("Donner le nom: ");
        tech.setNom(sc.nextLine());
        System.out.println("Donner le prénom: ");
        tech.setPrenom(sc.nextLine());
        System.out.println("Donner l'âge: ");
        tech.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner le sexe: ");
        tech.setSexe(sc.nextLine());
        System.out.println("Donner l'adresse: ");
        tech.setAdresse(sc.nextLine());
        System.out.println("Donner le téléphone: ");
        tech.setTelephone(sc.nextInt());
        sc.nextLine();
        System.out.println("Donner l'email: ");
        tech.setEmail(sc.nextLine());
        System.out.println("Donner le salaire: ");
        tech.setSalary(sc.nextDouble());
        sc.nextLine();
        System.out.println("Donner la spécialité: ");
        String input = sc.nextLine().toUpperCase();
        try {
            SpecialiteTechnicien specialite = SpecialiteTechnicien.valueOf(input);
            tech.setSpecialite(specialite);
        } catch (IllegalArgumentException e) {
            System.out.println("Entrée invalide. Veuillez choisir une spécialité valide.");
            tech.setSpecialite(null);
        }
        return tech;
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

    public static boolean saisirStatus() {
        System.out.println("Écrire le statut correspondant: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }
}
