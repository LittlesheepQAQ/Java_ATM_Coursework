package ATM;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankImpl implements Bank{
    private boolean SystemState;
    private HashMap<String, AccountInfo> users = new HashMap<>();
    private double interest = 0.05;
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
    public boolean userExist(String username) {
        return false;
    }

    @Override
    public void registerAccount(String username,String passport,String name,double balance)
    {
        AccountInfo temp = new AccountInfo(name,passport,balance);
        users.put(username,temp);
    }

    @Override
    public void calculateInterest() {
        Set<String> userId = users.keySet();
        AccountInfo temp;
        for(String id : userId){
            temp = users.get(id);
            temp.balance = interest * temp.balance + temp.balance;
        }
    }

    @Override
    public void exitSystem() {
        SystemState = false;
        singleThreadExcutor.shutdown();
    }

    public boolean login(String username, String passport) {
        if(users.containsKey(username))
        {
            AccountInfo temp = users.get(username);
            if(temp.passport.equals(passport)){
                currentAccountInfo = temp;
                currentUser = username;
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout() {
        currentUser = null;
        currentAccountInfo = null;
    }

    @Override
    public String getName() {
        if(currentUser.isEmpty()) throw new RuntimeException("不可能，用户未登录");
        return currentAccountInfo.name;
    }

    @Override
    public void changePassport(String newPassport) {
        if(currentUser.isEmpty()) throw new RuntimeException("不可能，用户未登录");
        currentAccountInfo.passport = newPassport;
    }

    @Override
    public void initUsersFromFile(File file) {
        try {
            //当文件不为空时
            if(file.length() != 0) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                users = (HashMap<String, AccountInfo>) ois.readObject();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUsersToFile(File file) {
        try {
            if(!users.isEmpty()) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(users);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public BankImpl(File file) {
        initUsersFromFile(file);
        SystemState = true;
        singleThreadExcutor.execute(new Runnable() {
            @Override
            public void run() {
                //每十秒执行计算利润
                while(SystemState)
                {
                    try {
                        Thread.sleep(10000);
                        calculateInterest();
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    ExecutorService singleThreadExcutor = Executors.newSingleThreadExecutor();
}
