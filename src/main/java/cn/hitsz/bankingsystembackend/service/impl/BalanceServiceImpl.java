package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.CustomerDao;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.service.BalanceService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Autowired
    CustomerDao customerDao;
    @Override
    public Long getBalance(Long id) {
        // TODO
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getId,id);
        List<Customer> customers =  customerDao.selectList(wrapper);
        if(customers.isEmpty()){
            return null;
        }
        Customer customer = customers.get(0);
        return customer.getBalance();
    }

    @Override
    public boolean transfer(Long id, String transferAccount, Long transferAmount) {
        // TODO 需要特别注意并发问题，合理运用 MyBatis Plus 事务和并发接口
        Customer customer1 = customerDao.selectById(id);
        Customer customer2 = customerDao.selectById(transferAccount);
        System.out.println("1 : " + id);
        System.out.println("2 : " + transferAccount);
        Long left = customer1.getBalance() - transferAmount;
        if(left >= 0){
            customer1.setBalance(left);
            customer2.setBalance(customer2.getBalance()+transferAmount);
            int a = customerDao.updateById(customer1);
            if(a == 0){
                return false;
            }
            int b = customerDao.updateById(customer2);
            if(b == 0){
                do{
                    b = customerDao.updateById(customer2);
                }while (b == 0);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(Long id ,Long depositAmount) {
        // TODO
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getId,id);
        List<Customer> customers =  customerDao.selectList(wrapper);
        if(customers.isEmpty()){
            return false;
        }
        Customer customer = customers.get(0);
        customer.setBalance(customer.getBalance()+depositAmount);
        if(customerDao.updateById(customer) != 0){
            return true;
        }
        return false;

    }
}
