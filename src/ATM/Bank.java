package ATM;
import java.util.HashMap;
import java.io.File;
public interface Bank {
    /**
     * 存款
     * @param num 存款的金额
     */
    public void deposit(double num);

    /**
     * 取款 并判断余额是否足够
     * @param num 取款的金额
     */
    public void withdraw(double num);

    /**
     * 返回当前用户余额
     * @return double 返回余额
     */
    public double query();

    /**
     * 判断当前是否存在对应用户名的用户信息
     * @param username 提供的用户名
     * @return 用户是否存在
     */
    public boolean userExist(String username);

    /**
     * 根据给定的用户名和密码登入系统 若用户名和密码正确则登入当前用户
     * @param username 提供的用户名
     * @param passport 提供的密码
     * @return 返回是否登入成功
     */
    public boolean login(String username, String passport);

    /**
     * 退出当前用户
     */
    public void logout();

    /**
     * 获得用户的姓名
     * @return 用户姓名
     */
    public String getName();

    /**
     * 改变密码
     * @param newPassport 新的密码
     */
    public void changePassport(String newPassport);

    /**
     * 通过文件初始化用户信息
     * @param file 存储文件
     */
    public void initUsersFromFile(File file);

    /**
     * 保存用户信息到外部文件中
     * @param file 存储文件
     */
    public void saveUsersToFile(File file);

    /**
     * 注册新用户
     * @param username 用户名
     * @param passport 密码
     * @param name 姓名
     * @param balance 余额
     */
    public void registerAccount(String username,String passport,String name,double balance);

    /**
     * 计算所有用户的利润
     */
    public void calculateInterest ();

    /**
     * 退出系统
     */
    public void exitSystem();
}
