package ATM;

import java.util.HashMap;

public class BankImpl implements Bank{
    final private HashMap<String, AccountInfo> users = new HashMap<String,AccountInfo>();
    private String currentUser;
    private AccountInfo currentAccountInfo;
    @Override
    public void deposit(double num)
    {
        if(currentUser.isEmpty()) throw new RuntimeException("不可能，用户未登录");
        currentAccountInfo.balance += num;
    }
    @Override
    public void withdraw(double num)
    {
        if(currentUser.isEmpty()) throw new RuntimeException("不可能，用户未登录");
        if(currentAccountInfo.balance < num) throw new RuntimeException("余额不足");
        currentAccountInfo.balance -= num;
    }
    @Override
    public double query(){
        if(currentUser.isEmpty()) throw new RuntimeException("不可能，用户未登录");
        return currentAccountInfo.balance;
    }
    @Override
    public void registerAccount(String username,String passport,String name,double balance)
    {
        AccountInfo temp = new AccountInfo(name,passport,balance);
        users.put(username,temp);
    }
    public boolean login(String username, String passport) {
        if(users.containsKey(username))
        {
            if(users)
        }
    }
    public BankImpl() {
    }
}
