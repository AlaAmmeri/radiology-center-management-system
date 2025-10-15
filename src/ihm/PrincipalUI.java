package ihm;

import controller.*;
import entities.InformationCentre;

import java.util.Scanner;

public class PrincipalUI {
    public static boolean initUI(InformationCentre informationCentre) {
        boolean n = true;
        Scanner sc = new Scanner(System.in);
        int option;
        do{
        if(informationCentre!=null) {
            System.out.println(informationCentre);
        }else {
            System.out.println("Error 404");
        }
        System.out.println("*******************************************");
        System.out.println("1)modifier information de Centre");
        System.out.println("2)gerer les Medecins Prescripteurs");
        System.out.println("3)gerer les Medecins Radiologues");
        System.out.println("4)gerer les Techniciens");
        System.out.println("5)gerer les patients");
        System.out.println("6)gerer les salles");
        System.out.println("7)gerer Finance");
        System.out.println("8)gerer les Rendez vous");
        System.out.println("9)Quitter");
        System.out.println("*******************************************");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ControllerCentreRadialogie.initController();
                    break;
                case 2:
                    ControllerMedecinPrescripteur.initController();
                    break;
                case 3:
                    ControllerMedecinRadiologue.initController();
                    break;
                case 4:
                    ControllerTechnicien.initController();
                    break;
                case 5:
                    ControllerPatient.initController();
                    break;
                case 6:
                    ControllerSalle.initController();
                    break;
                case 7:
                    ControllerFinance.initController();
                    break;
                case 8:
                    ControllerRendezVous.initController();
                case 9:
                    n = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (n);
        System.out.println("Bye bye !!!");
        return true;
    }}
