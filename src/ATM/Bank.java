package ATM;
import java.util.HashMap;
import java.io.File;
public interface Bank {

    public void deposit(double num);
    public void withdraw(double num);
    public double query();
    public boolean userExist(String username);
    public boolean login(String username, String passport);
    public boolean logout();
    public void initUsersFromFile(File file);
    public void saveUsersToFile(File file);
    public void registerAccount(String username,String passport,String name,double balance);
}
