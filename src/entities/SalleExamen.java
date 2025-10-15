package entities;

import java.util.List;

public class SalleExamen {
    private int id;
    private Type examen;
    private String equipements;
    private List<String> unavailableDates;

    public SalleExamen(int id, Type examen, String equipements, List<String> unavailableDates) {
        super();
        this.id = id;
        this.examen = examen;
        this.equipements = equipements;
        this.unavailableDates = unavailableDates;
    }

    public SalleExamen() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getExamen() {
        return examen;
    }

    public void setExamen(Type examen) {
        this.examen = examen;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    public List<String> getUnavailableDates() {
        return unavailableDates;
    }

    public void setUnavailableDates(List<String> unavailableDates) {
        this.unavailableDates = unavailableDates;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", examen='" + examen + '\'' +
                ", equipements='" + equipements + '\'' +
                ", unavailableDates=" + unavailableDates +
                '}';
    }
}
