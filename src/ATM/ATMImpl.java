package ATM;
import java.io.Console;
import java.util.Scanner;

public class ATMImpl implements ATM{
    public Scanner sc = new Scanner(System.in);
    Console console = System.console();
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
                    //registerNewAccount();
                    break;
                case 3:
                    //system_exit();
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

    }

    @Override
    public void registerNewAccount(){

    }

    @Override
    public void inter_Usermenu(){
        System.out.println("请选择操作：");
        System.out.println("1.查询余额");
        System.out.println("2.取款");
        System.out.println("3.存款");
        System.out.println("4.退出用户");
        int choice;
        choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1:
                System.out.println("用户余额为：" + bank.query());
                break;
            case 2:
                System.out.println("请输入取款额（¥）：");
        }
    }

    @Override
    public void user_deposit(){

    }

    @Override
    public void user_withdraw() {

    }

    @Override
    public void user_query() {

    }

    @Override
    public void user_exit() {

    }


    public static void main(String[] argu)
    {
        ATM atm = new ATMImpl();
        atm.inter_Startmenu();
    }
}
