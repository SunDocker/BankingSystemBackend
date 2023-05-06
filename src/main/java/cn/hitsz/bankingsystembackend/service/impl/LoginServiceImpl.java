package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.dao.TestClerkDao;
import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.dao.entity.TestCustomer;
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
    TestClerkDao testClerkDao;

    @Override
    public List<TestClerk> getTestClerk() {
        return testClerkDao.selectList(null);
    }

    @Override
    public void addTestClerk() {
        TestClerk testClerk = new TestClerk();

        // MybatisPlus 默认用雪花算法生成实体的 id，不需要我们自己指定
        // testClerk.setId(xxx);
        testClerk.setUsername("user" + System.currentTimeMillis());
        testClerk.setPassword(String.valueOf(System.currentTimeMillis()));

        testClerkDao.insert(testClerk);
    }

    @Override
    public void updateTestClerk() {
        List<TestClerk> testClerks = testClerkDao.selectList(null);
        for (TestClerk testClerk : testClerks) {
            testClerk.setUsername("updated-"+testClerk.getUsername());
            LambdaQueryWrapper<TestClerk> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(TestClerk::getId, testClerk.getId());
            testClerkDao.update(testClerk, wrapper);
        }
    }

    @Override
    public void deleteTestClerk() {
        testClerkDao.delete(null);
    }

    @Override
    public List<TestCustomer> getTestCustomer() {
        // TODO
        throw new RuntimeException();
    }

    @Override
    public void addTestCustomer() {
        // TODO
        throw new RuntimeException();
    }

    @Override
    public void updateTestCustomer() {
        // TODO
        throw new RuntimeException();
    }

    @Override
    public void deleteTestCustomer() {
        // TODO
        throw new RuntimeException();
    }
}
