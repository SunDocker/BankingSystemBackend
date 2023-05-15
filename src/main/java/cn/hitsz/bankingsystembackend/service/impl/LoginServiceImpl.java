package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.ClerkDao;
import cn.hitsz.bankingsystembackend.dao.CustomerDao;
import cn.hitsz.bankingsystembackend.dao.entity.Clerk;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    /**
     * 这个报错不用管。
     * 因为 MybatisPlus 在运行时才生成实现类，所以编译器暂时检测不到。
     */
    ClerkDao clerkDao;

    @Autowired
    CustomerDao customerDao;

    @Override
    public boolean clerkRegister(String username, String password) {
        // TODO
        LambdaQueryWrapper<Clerk> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Clerk::getUsername,username);
        List<Clerk> clerks = clerkDao.selectList(wrapper);
        if(!clerks.isEmpty()){
            return false;
        }
        Clerk clerk = new Clerk();
        clerk.setUsername(username);
        clerk.setPassword(password);
        clerk.setState(0);
        if(clerkDao.insert(clerk) != 0){
            return true;
        }
        return false;

    }

    @Override
    public Long clerkLogin(String username, String password) {
        // TODO
        LambdaQueryWrapper<Clerk> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Clerk::getUsername,username);
        List<Clerk> clerks = clerkDao.selectList(wrapper);
        if(clerks.isEmpty()){
            return null;
        }
        Clerk clerk = clerks.get(0);
        if(clerk.getPassword().equals(password)){
            return clerk.getId();
        }
        return null;

    }

    @Override
    public Long customerLogin(String username, String password) {
        // TODO
        LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Customer::getUsername,username);
        List<Customer> customers = customerDao.selectList(wrapper);
        if(customers.isEmpty()){
            return null;
        }
        Customer customer = customers.get(0);
        if(customer.getPassword().equals(password)){
            return customer.getId();
        }
        return null;
    }
}
