package mou.boot.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: JianTao Li
 * @time: 2021/3/4 13:13
 * @email: myskybeyond@163.com
 */
@SpringBootApplication
@MapperScan(value = {"mou.boot.app"})
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
