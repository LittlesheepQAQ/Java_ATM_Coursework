package ATM;
import java.util.Scanner;

public class ATMImpl implements ATM{
    public Scanner sc = new Scanner(System.in);
    @Override
    public void menu() throws Exception
    {
        while(true)
        {
            System.out.println("欢迎使用本ATM，请选择你的服务：\n" +
                    "1.初始化用户\n" +
                    "2.取钱\n" +
                    "3.存钱\n" +
                    "4.查询余额\n" +
                    "5.退出菜单");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                if(choice > 0 && choice <=5)
                {
                    switch(choice){
                        case 1:
                            System.out.println("请输入用户姓名：");
                            String name = sc.nextLine();
                            System.out.println("请输入初始化金额($)");
                            double balance = Double.parseDouble(sc.nextLine());
                            bank.setAccount(name,balance);
                            break;
                        case 2:
                            double amount;
                            System.out.println("请输入取钱金额($)：");
                            amount = Double.parseDouble(sc.nextLine());
                            bank.withdraw(amount);
                            break;
                        case 3:
                            double amount2;
                            System.out.println("请输入存钱金额($)：");
                            amount2 = Double.parseDouble(sc.nextLine());
                            bank.deposit(amount2);
                            break;
                        case 4:
                            double balance2 = bank.query();
                            System.out.println("余额为($)："+balance2);
                            break;
                        case 5:
                            return;
                    }
                }
                else throw new Exception("输入字符错误");
            } catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public ATMImpl()
    {

    }
    public static void main(String argu[])
    {
        ATM atm = new ATMImpl();
        try{
            atm.menu();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
