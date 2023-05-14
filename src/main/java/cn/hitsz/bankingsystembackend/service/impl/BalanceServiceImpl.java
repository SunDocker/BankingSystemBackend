package cn.hitsz.bankingsystembackend.service.impl;

import cn.hitsz.bankingsystembackend.service.BalanceService;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public Long getBalance(Long id) {
        return 1234567899999L;
    }

    @Override
    public boolean transfer(Long id, String transferAccount, Long transferAmount) {
        return true;
    }
}
