package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.pojo.ResponseMessage;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @PostMapping("register/{username}/{password}")
    @ResponseBody
    public ResponseMessage clerkRegister(@PathVariable("username") String username, @PathVariable("password") String password) {
        if (loginService.clerkRegister(username, password)) {
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }

    @GetMapping("register/{username}/{password}")
    @ResponseBody
    public ResponseMessage clerkLogin(@PathVariable("username") String username, @PathVariable("password") String password, HttpSession session) {
        if (loginService.clerkLogin(username, password)) {
            session.setAttribute("login", true);
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }

}
