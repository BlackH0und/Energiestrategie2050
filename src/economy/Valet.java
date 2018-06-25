package economy;

import java.text.DecimalFormat;

// @Marc Did you mean Wallet?
public class Valet {
    private double balance = 0.0;

    public void addBalance(double add){
        balance += add;
    }
    public void removeBalance(double remove){
        balance -= remove;
    }

    public double getBalance() {
        return balance;
    }
    public String getBalanceAsText(){
        return DecimalFormat.getInstance().format(balance);
    }
}
