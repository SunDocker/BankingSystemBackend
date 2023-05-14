package cn.hitsz.bankingsystembackend.service;

import cn.hitsz.bankingsystembackend.dao.entity.Clerk;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.dao.entity.TestCustomer;

import java.util.List;

/**
 * 负责 Clerk 和 Customer 的注册、登录等。
 * 目前先用 get, add, update, delete 这些方法名，
 * 之后会统一修改成注册、登录相关的方法名
 */
public interface LoginService {

    List<Clerk> getClerk();

    void addClerk();

    void updateClerk();

    void deleteClerk();

    List<Customer> getCustomer();

    void addCustomer(Long clerkId);

    void updateCustomer();

    void deleteCustomer();
}
