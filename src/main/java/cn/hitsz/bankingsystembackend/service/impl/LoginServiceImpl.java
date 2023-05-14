package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.ClerkDao;
import cn.hitsz.bankingsystembackend.dao.CustomerDao;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return true;
    }

    @Override
    public Long clerkLogin(String username, String password) {
        // TODO
        return 12345666L;
    }

    @Override
    public Long customerLogin(String username, String password) {
        // TODO
        return 12345666L;
    }
}
