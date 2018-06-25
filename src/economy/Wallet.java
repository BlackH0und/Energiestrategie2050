package economy;

import java.text.DecimalFormat;

public class Wallet {
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
