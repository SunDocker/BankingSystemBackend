package cn.hitsz.bankingsystembackend.dao.entity;

public class Customer {
    // TODO: 数据库中的表已经创建好了，现在要编写这个实体类，重写 toString() 方法
    private Long id;
    private Long clerk_id;
    private String username;
    private String password;
    private Long balance;
    private int state;





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

    public int getState() {
        return state;
    }

    public void setState(int State) {
        this.state = state;
    }

    public Long getClerk_id() { return clerk_id; }

    public void setClerk_id(Long clerk_id) { this.clerk_id = clerk_id; }

    @Override
    public String toString() {
        return "TestCustomer{" +
                "id=" + id +
                ", clerk_id='" + clerk_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
