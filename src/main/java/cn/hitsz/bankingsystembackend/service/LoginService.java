package cn.hitsz.bankingsystembackend.service;

/**
 * 负责 Clerk 和 Customer 的注册、登录等。
 * 目前先用 get, add, update, delete 这些方法名，
 * 之后会统一修改成注册、登录相关的方法名
 */
public interface LoginService {

    /**
     * 职员注册
     * @param username 职员用户名
     * @param password 职员密码
     * @return 是否注册成功
     */
    boolean clerkRegister(String username, String password);

    /**
     * 职员登录
     *
     * @param username 职员用户名
     * @param password 职员密码
     * @return 是否登录成功
     */
    Long clerkLogin(String username, String password);

    /**
     * 客户登录
     *
     * @param username 客户用户名
     * @param password 客户密码
     * @return 是否登录成功
     */
    Long customerLogin(String username, String password);
}
