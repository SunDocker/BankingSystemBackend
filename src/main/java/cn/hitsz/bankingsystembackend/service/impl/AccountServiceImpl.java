package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.service.AccountService;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Customer> getAccounts(Long clerkID) {
        // TODO

        // 下面只是测试数据，开发时请自行删除
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setUsername("LeiXun");
        customer1.setPassword("lx666");
        customer1.setId(999888777L);
        Customer customer2 = new Customer();
        customer2.setUsername("XunLei");
        customer2.setPassword("666xl");
        customer2.setId(777888999L);
        customers.add(customer1);
        customers.add(customer2);
        // 测试数据结束

        return customers;
    }

    @Override
    public boolean createAccount(Long clerkID, String username, String password) {
        // TODO
        return true;
    }

    @Override
    public boolean deleteAccount(Long clerkID, Long accountId) {
        // TODO
        return true;
    }
}
