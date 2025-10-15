package ihm;

import controller.ControllerMedecinPrescripteur;
import entities.MedecinPrescripteur;
import entities.SpecialitePrescripteur;

import java.util.Scanner;

public class GestionPrescripteurUI {
    public static void initUI(){
        Scanner sc = new Scanner(System.in);
        boolean quit = true;
        int id;
        MedecinPrescripteur[] m;
        MedecinPrescripteur med;
        do{
        System.out.println("1)Afficher tous les medecins prescripteurs");
        System.out.println("2)Ajouter un medecin prescripteur");
        System.out.println("3)Supprimer un medecin prescripteur");
        System.out.println("4)Modifier Un Medecin Prescripteur(does not fonction at the moment :/");
        System.out.println("5)afficher par ID: ");
        System.out.println("6)Quitter");
        switch(sc.nextInt()) {
            case 1:
                m=ControllerMedecinPrescripteur.afficherTous();
                if(m==null){
                    System.out.println("Erroe 404");
                }else{
                    for(MedecinPrescripteur mp:m){
                        System.out.println(mp);
                    }
                }
                break;
            case 2:
                if(ControllerMedecinPrescripteur.addMedecinPrescripteur()){
                    System.out.println("Prescripteur ajouté avec succes!");
                }
                else{
                    System.out.println("Erreur de suppression");
                }
                break;
            case 3:
                if(!ControllerMedecinPrescripteur.removeMedPrescripteur()){
                    System.out.println("Error occured or ID don't exist");
                }else {
                    System.out.println("Meddecin Prescripteur removed successfully");
                }
                break;
            case 4:
                System.out.println("Saisir l'ID");
                id = sc.nextInt();
                ControllerMedecinPrescripteur.modifierPrescripteur(id);
            case 5:
                System.out.println("Saisir l'ID: ");
                id = sc.nextInt();
                med= ControllerMedecinPrescripteur.getByID(id);
                if(med==null){
                    System.out.println("Erreur de suppression or ID don't exist");
                }else {
                    System.out.println(med);
                }
                break;
            case 6:
                quit = false;
                break;
        }
        }while(quit);
    }
    public static MedecinPrescripteur createMedecinPrescripteur(){
        MedecinPrescripteur med = new MedecinPrescripteur();
        Scanner sc = new Scanner(System.in);
        med.setId(-1);
        med.setUnavailableDates(null);
        System.out.println("donner le nom: ");
        med.setNom(sc.nextLine());
        System.out.println("donner le prenom: ");
        med.setPrenom(sc.nextLine());
        System.out.println("donner l'age: ");
        med.setAge(sc.nextInt());
        sc.nextLine();
        System.out.println("donner le sexe: ");
        med.setSexe(sc.nextLine());
        System.out.println("donner l'adresse: ");
        med.setAdresse(sc.nextLine());
        System.out.println("donner le telephone: ");
        med.setTelephone(sc.nextInt());
        sc.nextLine();
        System.out.println("donner le email: ");
        med.setEmail(sc.nextLine());
        System.out.println("donner le salaire: ");
        med.setSalary(sc.nextDouble());
        sc.nextLine();
        System.out.println("donner la specialité: ");
        String input = sc.nextLine().toUpperCase(); // Normalize input to uppercase
        try {
            // Convert the input string to the enum type and assign it to the variable
            SpecialitePrescripteur specialite = SpecialitePrescripteur.valueOf(input);
            med.setSpecialite(specialite);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Please choose from the listed specialities.");
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
