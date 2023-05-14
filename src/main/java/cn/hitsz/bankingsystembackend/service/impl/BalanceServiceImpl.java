package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public Long getBalance(Long id) {
        // TODO
        return 1234567899999L;
    }

    @Override
    public boolean transfer(Long id, String transferAccount, Long transferAmount) {
        // TODO 需要特别注意并发问题，合理运用 MyBatis Plus 事务和并发接口
        return true;
    }

    @Override
    public boolean deposit(Long depositAmount) {
        // TODO
        return true;
    }
}
