package cn.hitsz.bankingsystembackend.service;

public interface BalanceService {

    /**
     * 根据 id 获取客户余额
     * @param id 客户 id
     * @return 余额，出错则返回空
     */
    Long getBalance(Long id);

    /**
     * 转账
     * @param id 源客户 id
     * @param transferAccount 目标客户名
     * @param transferAmount 转账金额
     * @return 是否转账成功
     */
    boolean transfer(Long id, String transferAccount, Long transferAmount);
}
