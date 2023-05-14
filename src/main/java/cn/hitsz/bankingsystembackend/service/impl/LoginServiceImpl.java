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

}
