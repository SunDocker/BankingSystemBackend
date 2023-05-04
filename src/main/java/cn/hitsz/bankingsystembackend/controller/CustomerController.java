package cn.hitsz.bankingsystembackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("customer")
public class CustomerController {
    /**
     * 在本地运行项目，用浏览器访问接口：https://localhost:9999/customer/test
     * @return 若配置正确，则能在浏览器中看到"banking system customer test"
     */
    @GetMapping("test")
    public String test() {
        return "banking system customer test";
    }
}
