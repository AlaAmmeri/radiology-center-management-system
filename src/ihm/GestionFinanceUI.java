package ihm;

import controller.ControllerFinance;

import java.util.Scanner;

public class GestionFinanceUI {
    public static void initUi(){
        boolean quit = true;
        Scanner sc = new Scanner(System.in);
        double a;
        do {
            System.out.println("1) ajouter au total");
            System.out.println("2) soustracter du total");
            System.out.println("3) afficher total");
            System.out.println("4) quitter");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Veuillez choisir un valeur");
                    if(ControllerFinance.ajouterTotal(sc.nextDouble())){
                        System.out.println("ajout avec succes");
                    }else {
                        System.out.println("erreur");
                    }
                    break;
                case 2:
                    System.out.println("Veuillez choisir un valeur");
                    a=sc.nextDouble();
                    if(ControllerFinance.ajouterTotal(-a)){
                        System.out.println("soustraction avec succes");
                    }else {
                        System.out.println("erreur");
                    }

                    break;
                case 3:
                    System.out.println("valeur Total: "+ControllerFinance.getTotal());
                    break;
                case 4:
                    quit = false;
                    break;
            }
        }while(quit);
    }
}
