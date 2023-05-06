package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clerk")
@CrossOrigin
public class ClerkController {
    /**
     * controller 层调用 service 层
     */
    @Autowired
    LoginService loginService;

    /**
     * 在本地运行项目，用浏览器访问接口：https://localhost:9999/clerk/test
     *
     * @return 若配置正确，则能在浏览器中看到"banking system clerk test"
     */
    @GetMapping("test")
    public String test() {
        return "banking system clerk test";
    }

    @GetMapping()
    public String getTestClerk() {
        List<TestClerk> testClerk = loginService.getTestClerk();

        StringBuffer sb = new StringBuffer();
        for (TestClerk clerk : testClerk) {
            sb.append(clerk).append('\n');
        }
        return "retrieve response successfully, " +
                "test clerks:\n" + sb;
    }

    @PostMapping()
    public String addTestClerk() {
        loginService.addTestClerk();
        return "create response successfully, please check the database table";
    }

    @PutMapping()
    public String updateTestClerk() {
        loginService.updateTestClerk();
        return "update response successfully, please check the database table";
    }

    @DeleteMapping()
    public String deleteTestClerk() {
        loginService.deleteTestClerk();
        return "delete response successfully, please check the database table";
    }
}
