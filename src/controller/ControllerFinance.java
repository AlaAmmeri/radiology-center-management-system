package controller;

import ihm.GestionFinanceUI;
import services.ServiceFinance;

public class ControllerFinance {
    public static void initController() {
        GestionFinanceUI.initUi();
    }
    public static boolean ajouterTotal(double d){
        return ServiceFinance.ajouterTotal(d);
    }
    public static double getTotal(){
        return ServiceFinance.getTotal();
    }
}
