package cn.hitsz.bankingsystembackend.dao.entity;

public class TestClerk {
    // 必须使用基本数据类型的包装类，不能直接使用基本数据类型
    // 必须保证主键的字段名为 id，MyBatisPlus 才可以自动识别
    private Long id;
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "TestClerk{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
