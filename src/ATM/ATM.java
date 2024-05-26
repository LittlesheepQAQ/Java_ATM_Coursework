package ATM;

public interface ATM {
    public void inter_Startmenu() throws Exception;
    public void login();
    public void registerNewAccount();
    public void inter_Usermenu();
    public void user_deposit();
    public void user_withdraw();
    public void user_query();
    public Bank bank = new BankImpl();
}
