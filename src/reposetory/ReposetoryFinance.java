package reposetory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Finance;

import java.io.FileReader;
import java.io.FileWriter;

public class ReposetoryFinance {
    public static double getTotal(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileReader reader = new FileReader("src/reposetory/Finance.json");
            Finance finance = gson.fromJson(reader, Finance.class);
            return finance.getTotalBalance();
        }catch (Exception e){
            return -999999999;
        }
    }
    public static boolean setTotal(double total){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Finance finance=new Finance(total);
            FileWriter writer=new FileWriter("src/reposetory/Finance.json");
            gson.toJson(finance,writer);
            writer.close();
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
