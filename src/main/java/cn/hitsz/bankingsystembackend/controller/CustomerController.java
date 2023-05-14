package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.dao.TestClerkDao;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.dao.entity.TestCustomer;
import cn.hitsz.bankingsystembackend.pojo.ResponseMessage;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController()
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    LoginService loginService;

    /**
     * 在本地运行项目，用浏览器访问接口：https://localhost:9999/customer/test
     *
     * @return 若配置正确，则能在浏览器中看到"banking system customer test"
     */
    @GetMapping("test")
    public String test() {
        return "banking system customer test";
    }

    @GetMapping("login/{username}/{password}")
    public ResponseMessage customerLogin(@PathVariable("username") String username, @PathVariable("password") String password, HttpSession session) {
        if (loginService.customerLogin(username, password)) {
            session.setAttribute("login", true);
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }
}
