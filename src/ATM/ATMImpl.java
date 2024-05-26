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

    }

    @Override
    public void system_exit(){

    }

    @Override
    public void registerNewAccount(){

    }

    @Override
    public void inter_Usermenu(){

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
