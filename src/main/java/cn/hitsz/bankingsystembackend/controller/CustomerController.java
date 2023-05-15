package cn.hitsz.bankingsystembackend.controller;

import cn.hitsz.bankingsystembackend.pojo.ResponseMessage;
import cn.hitsz.bankingsystembackend.service.BalanceService;
import cn.hitsz.bankingsystembackend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController()
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    LoginService loginService;

    @Autowired
    BalanceService balanceService;

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
        Long id = loginService.customerLogin(username, password);
        if (id != null) {
            session.setAttribute("customerLogin", id);
            return new ResponseMessage(true, null);
        } else {
            return new ResponseMessage(false, null);
        }
    }

    @GetMapping("logout")
    public ResponseMessage logout(HttpSession session) {
        session.removeAttribute("customerLogin");
        return new ResponseMessage(true, null);
    }

    @GetMapping("balance")
    public ResponseMessage balance(HttpSession session) {
        Long id = (Long) session.getAttribute("customerLogin");
        if (id == null) {
            return new ResponseMessage(false, null);
        }
        Long balance = balanceService.getBalance(id);
        if (balance != null) {
            return new ResponseMessage(true, balance);
        } else {
            return new ResponseMessage(false, null);
        }
    }

    @PostMapping("deposit/{depositAmount}")
    public ResponseMessage deposit(@PathVariable("depositAmount") Long depositAmount, HttpSession session) {
        Long id = (Long) session.getAttribute("customerLogin");
        if (id == null) {
            return new ResponseMessage(false, null);
        }
        if (balanceService.deposit(id,depositAmount)) {
            return new ResponseMessage(true, null);
        }
        return new ResponseMessage(false, null);
    }

    @PostMapping("transfer/{transferAccount}/{transferAmount}")
    public ResponseMessage transfer(@PathVariable("transferAccount") String transferAccount, @PathVariable("transferAmount") Long transferAmount, HttpSession session) {
        Long id = (Long) session.getAttribute("customerLogin");
        if (id == null) {
            return new ResponseMessage(false, null);
        }
        if (balanceService.transfer(id, transferAccount, transferAmount)) {
            return new ResponseMessage(true, null);
        }
        return new ResponseMessage(false, null);
    }
}
