package ihm;

import controller.PrincipalController;
import entities.InformationCentre;

import java.util.Scanner;

public class ModifierCentreInformationUI {
    public static InformationCentre InitUI() {

        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom: ");
        String nom = sc.nextLine();
        System.out.println("entrer l'adresse: ");
        String adresse = sc.nextLine();
        System.out.println("entrer l'Email: ");
        String email = sc.nextLine();
        System.out.println("entrer numero Telephone: ");
        int telephone = sc.nextInt();
        sc.nextLine();
        System.out.println("entrer le Website adressse: ");
        String website = sc.nextLine();
        return new InformationCentre(nom,adresse,email,telephone,website);
    }
    public static void returnResultUI(boolean test){
        if(test){
            System.out.println("saved successfully");
        }else {
            System.out.println("not saved successfully");
        }
        PrincipalController.InitController();
    }
}
