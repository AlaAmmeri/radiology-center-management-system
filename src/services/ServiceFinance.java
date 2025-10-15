package services;

import reposetory.ReposetoryFinance;

public class ServiceFinance {
    public static boolean ajouterTotal(double d){
        double total= ReposetoryFinance.getTotal();
        total=total+d;
        return ReposetoryFinance.setTotal(total);
    }
    public static double getTotal(){
        return ReposetoryFinance.getTotal();
    }
}
