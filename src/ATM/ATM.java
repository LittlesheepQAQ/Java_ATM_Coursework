package ATM;

/**
 * @author yyx
 * @version 0.1
 *
 */
public interface ATM {
    /**
     * 用户初始交互界面 提供登入、注册、退出系统选项
     * @throws Exception
     */
    public void inter_Startmenu();

    /**
     * 用户登入交互
     */
    public void login();

    /**
     * 退出系统
     */
    public void system_exit();

    /**
     * 新建用户操作
     */
    public void registerNewAccount();

    /**
     * 用户主界面 包括取钱、存钱、查询余额操作
     */
    public void inter_Usermenu();

    /**
     * 用户存钱界面
     */
    public void user_deposit();

    /**
     * 用户取钱界面
     */
    public void user_withdraw();

    /**
     * 用户查询余额界面
     */
    public void user_query();

    /**
     * 用户退出
     */
    public void user_exit();
    public Bank bank = new BankImpl();
}
