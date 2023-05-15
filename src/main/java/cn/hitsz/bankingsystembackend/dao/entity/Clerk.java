package cn.hitsz.bankingsystembackend.dao.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class Clerk {
    // 必须使用基本数据类型的包装类，不能直接使用基本数据类型
    // 必须保证主键的字段名为 id，MyBatisPlus 才可以自动识别
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String username;
    private String password;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TestClerk{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
