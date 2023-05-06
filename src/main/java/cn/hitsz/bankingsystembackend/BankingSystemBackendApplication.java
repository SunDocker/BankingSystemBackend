package cn.hitsz.bankingsystembackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.hitsz.bankingsystembackend.dao")
public class BankingSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingSystemBackendApplication.class, args);
    }

}
