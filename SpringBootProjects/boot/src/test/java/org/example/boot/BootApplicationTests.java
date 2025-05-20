package org.example.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"name=catsbi", "email = test@test.com"})
class BootApplicationTests {

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;

    @Value("${name}")
    private String name;

    @Value("${email}")
    private String email;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        System.out.println("hello test1 " + driverName);
        System.out.println("hello test1 " + name);
        System.out.println("hello test1 " + email);
    }

}
