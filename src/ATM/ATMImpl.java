package ATM;
import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class ATMImpl implements ATM{
    Bank bank;
    public Scanner sc = new Scanner(System.in);
    File file;
    public ATMImpl(File file) throws Exception {
        this.file = file;
        if(!file.exists()){
            throw new Exception("文件不存在");
        }
        bank = new BankImpl(file);
    }

    @Override
    public void inter_Startmenu(){
        while(true){
            System.out.println("-------------欢迎使用本ATM系统-------------");
            System.out.println("1.用户登录");
            System.out.println("2.用户注册");
            System.out.println("3.退出系统");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    login();
                    break;
                case 2:
                    registerNewAccount();
                    break;
                case 3:
                    system_exit();
                    return;
            }
        }
    }

    @Override
    public void login(){
        System.out.println("输入用户名：");
        String username = sc.nextLine();
        System.out.println("输入密码：");
        String password = sc.nextLine();

        if(!bank.login(username,password)){                     //账号密码不正确
            System.out.println("--------账号密码不正确---------");
            return;
        }
        else{                                                   //账号密码正确
            System.out.println("登入成功，" + "欢迎" + bank.getName() + "用户");
            inter_Usermenu();                                   //进入二级用户界面
        }
    }

    @Override
    public void system_exit(){
        bank.saveUsersToFile(file);
        bank.exitSystem();
    }

    @Override
    public void registerNewAccount(){
        System.out.println("请输入用户名（ID）：");
        String id = sc.nextLine();
        while(bank.userExist(id)){
            System.out.println("当前用户名已存在 1.重新输入 2.退出注册");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("请输入用户名（ID）：");
                    id = sc.nextLine();
                    break;
                case 2:
                    return;
            }
        }
        System.out.println("请输入密码：");
        String password = sc.nextLine();
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入初始余额：");
        double balance = sc.nextDouble();
        bank.registerAccount(id,password,name,balance);
        System.out.println("账户注册成功");

    }

    @Override
    public void inter_Usermenu(){
        while(true){
            System.out.println("请选择操作：");
            System.out.println("1.更改密码");
            System.out.println("2.查询余额");
            System.out.println("3.存款");
            System.out.println("4.取款");
            System.out.println("5.退出账户");
            int choice;
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    changePassport();
                    break;
                case 2:
                    user_query();
                    break;
                case 3:
                    user_deposit();
                    break;
                case 4:
                    user_withdraw();
                    break;
                case 5:
                    user_exit();
                    return;
            }
        }
    }

    public void changePassport(){
        System.out.println("请输入新的密码：");
        String newPassport = sc.nextLine();
        bank.changePassport(newPassport);
        System.out.println("密码修改成功");
    }

    @Override
    public void user_deposit(){
        System.out.println("请输入存款金额：");
        double depositAmount = sc.nextDouble();
        sc.nextLine();
        bank.deposit(depositAmount);
        System.out.println("存款成功，当前余额为：" + bank.query());
    }

    @Override
    public void user_withdraw() {
        System.out.println("请输入取款金额：");
        double withdrawAmount = sc.nextDouble();
        sc.nextLine();
        if(bank.query() < withdrawAmount){
            System.out.println("余额不足，无法取款。");
        }
        else{
            bank.withdraw(withdrawAmount);
            System.out.println("取款成功，当前余额为："+ bank.query());
        }
    }

    @Override
    public void user_query() {
        System.out.println("当前账户余额为（￥）：" + bank.query());
    }

    @Override
    public void user_exit() {
        bank.logout();
    }


    public static void main(String[] argu)
    {
        File file = new File("UserInfo.dat");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        try{
            ATM atm = new ATMImpl(file);
            atm.inter_Startmenu();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
