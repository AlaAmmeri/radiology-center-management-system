package ihm;

import controller.ControllerRendezVous;
import entities.RendezVous;
import entities.Type;

import java.util.List;
import java.util.Scanner;

public class GestionRendezVousUI {
    public static void initUI(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        List<RendezVous> listRendezVous;
        RendezVous rendezVous;
        do {
            System.out.println("*********************************************************");
            System.out.println("1)afficher tous les rendez vous");
            System.out.println("2)afficher le rendez vous d'un patient");
            System.out.println("3)ajouter rendez vous");
            System.out.println("4)supprimer rendez vous");
            System.out.println("5)modifier rendez vous");
            System.out.println("6)Quitter");
            System.out.println("*********************************************************");
            switch(sc.nextInt()){
                case 1:
                    listRendezVous=ControllerRendezVous.obtenirTous();
                    if(listRendezVous!=null){
                        for (RendezVous r : listRendezVous){
                            System.out.println(r.toString());
                        }
                    }else{
                        System.out.println("pas de rendez vous !");
                    }
                    break;
                case 2:
                    System.out.println("donner l'id de patient");
                    rendezVous=ControllerRendezVous.getRendezVousID(sc.nextInt());
                    if(rendezVous!=null){
                        System.out.println(rendezVous);
                    }else {
                        System.out.println("pas de rendez vous !");
                    }
                    break;
                case 3:
                    ControllerRendezVous.ajouterRendezVous();
                    break;
                case 4:
                    System.out.println("saisir id rendez vous: ");
                    int idRendezVous = sc.nextInt();
                    sc.nextLine();
                    if(ControllerRendezVous.deleteRendezVous(idRendezVous)){
                        System.out.println("supprime avec success");
                    }else {
                        System.out.println("supprime avec failure");
                    }
                    break;

                    default:
                        System.out.println("choix invalide!");
                    
            }
        }while (flag);
    }
    public static RendezVous createRendezVous(){
        RendezVous rendezVous=new RendezVous();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int idSalle;
        int idRadiologue;
        int idTechnicien;
        System.out.println("donner l'id de patient");
        rendezVous.setIdPatient(sc.nextInt());
        sc.nextLine();
        System.out.println("donner la date de rendez vous");
        rendezVous.setDate(sc.nextLine());
        System.out.println("donner le type d'examen");
        String input = sc.nextLine().toUpperCase();
        try {
            Type examen = Type.valueOf(input);
            rendezVous.setExamenType(examen);
        } catch (IllegalArgumentException e) {
            System.out.println("Type invalide. Réessayez.");
        }
        while(flag) {
            System.out.println("donner l'id de salle");
            idSalle = sc.nextInt();
            if (ControllerRendezVous.checkSalleType(rendezVous.getExamenType(), idSalle)) {
                if (ControllerRendezVous.checkDateSalle(rendezVous.getDate(),idSalle)){
                    ControllerRendezVous.reserverSalle(rendezVous.getDate(),idSalle);
                    rendezVous.setIdSalle(idSalle);
                    flag = false;
                }else {
                    System.out.println("cette salle est reserve dans ce temps!");
                }
            }else{
                System.out.println("choix inconvinient de salle(type examen)");
            }
        }
        flag=true;
        while (flag) {
            System.out.println("donner l'id de Radiologue");
            idRadiologue = sc.nextInt();
            sc.nextLine();
            if(ControllerRendezVous.checkDateRadiologue(rendezVous.getDate(),idRadiologue)){
                flag=false;
                ControllerRendezVous.reserverRadiologue(rendezVous.getDate(),idRadiologue);
                rendezVous.setIdRadiologue(idRadiologue);
            }else {
                System.out.println("ce radiologue est reserve dans ce temps!");
            }
        }
        flag=true;
        while (flag) {
            System.out.println("donner l'id de Technicien");
            idTechnicien = sc.nextInt();
            sc.nextLine();
            if (ControllerRendezVous.checkDateTechnicien(rendezVous.getDate(),idTechnicien)){
                flag=false;
                ControllerRendezVous.reserverTechnicien(rendezVous.getDate(),idTechnicien);
                rendezVous.setIdTechnicien(idTechnicien);
            }else {
                System.out.println("ce technicien est reserve dans ce temps!");
            }
        }
        rendezVous.setIdRendezVous(ControllerRendezVous.generateID());
        System.out.println("ajout avec success!");
        return rendezVous;

    }
}
