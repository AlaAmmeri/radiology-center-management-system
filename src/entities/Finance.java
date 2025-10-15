package entities;

public class Finance {
    private double TotalBalance;
    public Finance() {}
    public Finance(double balance) {
        TotalBalance = balance;
    }
    public double getTotalBalance() {
        return TotalBalance;
    }
    public void setTotalBalance(double totalBalance) {
        TotalBalance = totalBalance;
    }
    public String toString() {
        return "\nTotal Balance: " + TotalBalance;
    }
}
