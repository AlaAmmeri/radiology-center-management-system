package ihm;

import controller.ControllerSalle;
import controller.PrincipalController;
import entities.SalleExamen;
import entities.Type;

import java.util.Scanner;

public class GestionSalleUI {
    public static void initUI() {
        SalleExamen[] tab;
        boolean test = true;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("1)afficher tous les salles");
            System.out.println("2)Ajouter une salle");
            System.out.println("3)supprimer une salle");
            System.out.println("5)modifier une salle(not ready yet :/");
            System.out.println("6)not ready yet :/");
            System.out.println("7)quit");
            switch (scan.nextInt()) {
                case 1:
                    tab = ControllerSalle.afficher();
                    if (tab == null) {
                        System.out.println("Pas de Salles");
                    } else {
                        for (SalleExamen salleExamen : tab) {
                            System.out.println(salleExamen);
                        }
                    }
                    PrincipalController.InitController();
                    break;
                case 2:
                    if (ControllerSalle.addSalle()) {
                        System.out.println("Salle ajouté avec succes!");
                    } else {
                        System.out.println("error occured");
                    }
                    PrincipalController.InitController();
                    break;
                case 3:
                    if (ControllerSalle.suppSalle()) {
                        System.out.println("supprimé avec succes!");
                    } else {
                        System.out.println("error occured or Id doesn't exist");
                    }
                    PrincipalController.InitController();
                    break;
                case 4:
                    ControllerSalle.modifierSalle();
                    break;
                case 5:
                    ControllerSalle.modifierSalle();
                    break;
                case 6:
                    System.out.println("Veuillez choisir une salle");
                    break;
                case 7:
                    test = false;
                    break;
                default:
                    System.out.println("Chois invalide");
            }

        } while (test);
    }
    public static SalleExamen addSalle(){
        SalleExamen salleExamen=new SalleExamen();
        salleExamen.setId(-1);
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisir l'equipement: ");
        salleExamen.setEquipements(scan.nextLine());
        System.out.println("Saisir le type d'examen: ");
        String input = scan.nextLine().toUpperCase(); // Normalize input to uppercase

        try {
            // Convert the input string to the enum type
            Type examen = Type.valueOf(input);
            salleExamen.setExamen(examen);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please choose from the listed specialities.");
        }
        return salleExamen;
    }
    public static int getIDSalle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Veuillez choisir un ID: ");
        return scan.nextInt();
    }
    public static void modifierSalleUI(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisir l'ID de salle: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("1)Modifier tous: ");
        System.out.println("2)modifier temps non valable: ");
        int option= scan.nextInt();
        switch(option){
            case 1:
                SalleExamen salleExamen=new SalleExamen();
                System.out.println("Saisir l'equipement: ");
                salleExamen.setEquipements(scan.nextLine());
                System.out.println("Saisir le type d'examen: ");
                String input = scan.nextLine().toUpperCase();
                try {
                    Type examen = Type.valueOf(input);
                    salleExamen.setExamen(examen);
                }catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please choose from the listed specialities.");
                }
                break;
            case 2:
                break;
        }

    }
}
