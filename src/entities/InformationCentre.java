package entities;

public class InformationCentre {
    private String name;
    private String adress;
    private String Email;
    private int telephone;
    private String website;

    public InformationCentre(String name, String adress, String email, int telephone, String website) {
        this.name = name;
        this.adress = adress;
        this.Email = email;
        this.telephone = telephone;
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
     public String toString() {
        return "\n"+name + "\n" + adress + "\n" + Email + "\nNumTel: " + telephone + "\n" + website;
     }

}
