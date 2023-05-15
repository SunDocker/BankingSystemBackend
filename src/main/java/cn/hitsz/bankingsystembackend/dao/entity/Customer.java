package cn.hitsz.bankingsystembackend.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Customer {
    // TODO: 数据库中的表已经创建好了，现在要编写这个实体类，重写 toString() 方法
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long clerkId;
    private String username;
    private String password;
    private Long balance;
    private Integer state;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getClerkId() { return clerkId; }

    public void setClerkId(Long clerkId) { this.clerkId = clerkId; }

    @Override
    public String toString() {
        return "TestCustomer{" +
                "id=" + id +
                ", clerkId='" + this.clerkId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
