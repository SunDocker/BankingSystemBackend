package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.dao.TestClerkDao;
import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.dao.entity.TestClerk;
import cn.hitsz.bankingsystembackend.dao.entity.TestCustomer;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping()
    public String getTestCustomer() {
        List<Customer> customers = loginService.getCustomer();

        StringBuffer sb = new StringBuffer();
        for (Customer customer : customers) {
            System.out.println(customer.getClerkId());
            sb.append(customer).append('\n');
        }
        return "retrieve response successfully, " +
                "test customers:\n" + sb;
    }

    @PostMapping()
    public String addTestCustomer() {
        loginService.addCustomer(loginService.getClerk().get(0).getId());
        return "create response successfully, please check the database table";
    }

    @PutMapping()
    public String updateTestCustomer() {
        loginService.updateCustomer();
        return "update response successfully, please check the database table";
    }

    @DeleteMapping()
    public String deleteTestCustomer() {
        loginService.deleteCustomer();
        return "delete response successfully, please check the database table";
    }
}
