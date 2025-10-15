package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Personne {
    private double salary;
    private List<String> unavailableDates; // List of unavailable dates

    // Default constructor
    public Employee() {
    }

    // Constructor with parameters
    public Employee(int ID, String nom, String prenom, int age, String sexe, String adresse, String email, int telephone, double salary) {
        super(ID, nom, prenom, age, sexe, adresse, email, telephone);
        this.salary = salary;
        this.unavailableDates = new ArrayList<>(); // Initialize as empty list

    }

    // Getter for salary
    public double getSalary() {
        return salary;
    }

    // Setter for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter for unavailable dates
    public List<String> getUnavailableDates() {
        return unavailableDates;
    }

    // Setter for unavailable dates
    public void setUnavailableDates(List<String> unavailableDates) {
        this.unavailableDates = unavailableDates;
    }

    // Simplified toString method
    @Override
    public String toString() {
        String result = super.toString() + "\nSalary: " + salary + "\nUnavailable Dates:";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (unavailableDates != null) {
            for (String date : unavailableDates) {
                result += "\n" + date;
            }
        }
        return result;
    }
}
