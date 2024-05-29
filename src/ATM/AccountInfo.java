package ATM;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    String name;
    String passport;
    double balance;

    AccountInfo(String name,String passport,double balance)
    {
        this.name = name;
        this.passport = passport;
        this.balance = balance;
    }
}
