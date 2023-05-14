package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.dao.entity.Customer;
import cn.hitsz.bankingsystembackend.pojo.ResponseMessage;
import cn.hitsz.bankingsystembackend.service.AccountService;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("clerk")
public class ClerkController {
    /**
     * controller 层调用 service 层
     */
    @Autowired
    LoginService loginService;

    @Autowired
    AccountService accountService;

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
    public ResponseMessage clerkRegister(@PathVariable("username") String username, @PathVariable("password") String password) {
        if (loginService.clerkRegister(username, password)) {
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }

    @GetMapping("login/{username}/{password}")
    public ResponseMessage clerkLogin(@PathVariable("username") String username, @PathVariable("password") String password, HttpSession session) {
        Long id = loginService.clerkLogin(username, password);
        if (id != null) {
            session.setAttribute("clerkLogin", id);
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }

    @GetMapping("logout")
    public ResponseMessage logout(HttpSession session) {
        session.removeAttribute("clerkLogin");
        return new ResponseMessage(true, null);
    }

    @GetMapping("account")
    public ResponseMessage getAccounts(HttpSession session) {
        Long clerkID = (Long) session.getAttribute("clerkLogin");
        if (clerkID == null) {
            return new ResponseMessage(false, null);
        }
        List<Customer> accounts = accountService.getAccounts(clerkID);
        if (accounts != null) {
            return new ResponseMessage(true, accounts);
        }
        return new ResponseMessage(false, null);

    }

    @PostMapping("account/{username}/{password}")
    public ResponseMessage createAccount(@PathVariable("username") String username, @PathVariable("password") String password, HttpSession session) {
        Long clerkID = (Long) session.getAttribute("clerkLogin");
        if (clerkID == null) {
            return new ResponseMessage(false, null);
        }
        if (accountService.createAccount(clerkID, username, password)) {
            return new ResponseMessage(true, null);
        }
        return new ResponseMessage(false, null);

    }

    @DeleteMapping("account/{accountId}")
    public ResponseMessage deleteAccount(@PathVariable("accountId") Long accountId, HttpSession session) {
        Long clerkID = (Long) session.getAttribute("clerkLogin");
        if (clerkID == null) {
            return new ResponseMessage(false, null);
        }
        if (accountService.deleteAccount(clerkID, accountId)) {
            return new ResponseMessage(true, null);
        }
        return new ResponseMessage(false, null);

    }

}
