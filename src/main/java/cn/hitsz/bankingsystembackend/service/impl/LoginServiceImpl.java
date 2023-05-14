package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.ClerkDao;
import cn.hitsz.bankingsystembackend.dao.CustomerDao;
import cn.hitsz.bankingsystembackend.dao.entity.Clerk;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<Clerk> getClerk() {
        return clerkDao.selectList(null);
    }

    @Override
    public void addClerk() {
        Clerk clerk = new Clerk();

        // MybatisPlus 默认用雪花算法生成实体的 id，不需要我们自己指定
        // testClerk.setId(xxx);
        clerk.setUsername("user" + System.currentTimeMillis());
        clerk.setPassword(String.valueOf(System.currentTimeMillis()));
        clerk.setState(0);

        clerkDao.insert(clerk);
    }

    @Override
    public void updateClerk() {
        List<Clerk> clerks = clerkDao.selectList(null);
        for (Clerk clerk : clerks) {
            clerk.setUsername("updated-"+clerk.getUsername());
            LambdaQueryWrapper<Clerk> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Clerk::getId, clerk.getId());
            clerkDao.update(clerk, wrapper);
        }
    }

    @Override
    public void deleteClerk() {
        clerkDao.delete(null);
    }

    @Override
    public List<Customer> getCustomer() {
        // TODO
        return customerDao.selectList(null);
    }

    @Override
    public void addCustomer(Long clerkId) {
        // TODO
        Customer customer = new Customer();

        // MybatisPlus 默认用雪花算法生成实体的 id，不需要我们自己指定
        // testClerk.setId(xxx);
        customer.setClerkId(clerkId);
        System.out.println(customer.getClerkId());
        customer.setUsername("user" + System.currentTimeMillis());
        customer.setPassword(String.valueOf(System.currentTimeMillis()));
        customer.setState(0);
        customer.setBalance(0L);
        System.out.println(customer);

        customerDao.insert(customer);
    }

    @Override
    public void updateCustomer() {
        // TODO
        List<Customer> customers = customerDao.selectList(null);
        for (Customer customer : customers) {
            customer.setUsername("updated-"+customer.getUsername());
            LambdaQueryWrapper<Customer> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Customer::getId, customer.getId());
            customerDao.update(customer, wrapper);
        }
    }

    @Override
    public void deleteCustomer() {
        // TODO
        customerDao.delete(null);
    }
}
