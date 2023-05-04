package cn.hitsz.bankingsystembackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clerk")
public class ClerkController {
    /**
     * 在本地运行项目，用浏览器访问接口：https://localhost:9999/clerk/test
     * @return 若配置正确，则能在浏览器中看到"banking system clerk test"
     */
    @GetMapping("test")
    public String test() {
        return "banking system clerk test";
    }
}
