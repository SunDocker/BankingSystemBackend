package cn.hitsz.bankingsystembackend.service;

import cn.hitsz.bankingsystembackend.dao.entity.Customer;

import java.util.List;

public interface AccountService {
    /**
     * 获取 clerkID 对应职员创建的所有客户信息
     * @param clerkID 职员 ID
     * @return 所有客户信息集合
     */
    List<Customer> getAccounts(Long clerkID);

    /**
     * 在 clerkID 对应职员下创建一个新客户账号
     * @param clerkID 职员 ID
     * @param username 新客户账号名
     * @param password 新客户账号密码
     * @return 是否创建成功
     */
    boolean createAccount(Long clerkID, String username, String password);

    /**
     * 在 clerkID 对应职员下删除一个客户账号
     * @param clerkID 职员 ID
     * @param accountId 要删除的客户账号 ID
     * @return 是否删除成功
     */
    boolean deleteAccount(Long clerkID, Long accountId);
}
