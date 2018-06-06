package economy;

import java.text.DecimalFormat;

public class Valet {
    private double balance = 0.0;

    public double getBalance() {
        return balance;
    }
    public String getBalanceAsText(){
        return DecimalFormat.getInstance().format(balance);
    }
}
