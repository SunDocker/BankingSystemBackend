package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.ClerkDao;
import cn.hitsz.bankingsystembackend.dao.CustomerDao;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> getAccounts(Long clerkID) {
        // TODO

        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getClerkId,clerkID);
        return customerDao.selectList(wrapper);
        // 下面只是测试数据，开发时请自行删除
        /*
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
        */

    }

    @Override
    public boolean createAccount(Long clerkID, String username, String password) {
        // TODO

        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getUsername,username);
        List<Customer> customers = customerDao.selectList(wrapper);
        if(!customers.isEmpty()){
            return false;
        }
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setClerkId(clerkID);
        customer.setBalance(0L);
        customer.setState(0);
        customerDao.insert(customer);
        return true;
    }

    @Override
    public boolean deleteAccount(Long clerkID, Long accountId) {
        // TODO
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getId,accountId);
        List<Customer> customers = customerDao.selectList(wrapper);
        System.out.println("ID :" + accountId);
        if(customers.isEmpty()){
            return false;
        }
        customerDao.delete(wrapper);
        return true;
    }
}
