package com.example.demo;

//import org.apache.catalina.core.ApplicationContext; // sherwin: wrong import

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.text.NumberFormat;

//@ExtendWith(SpringExtension.class)  // sherwin: no need
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    @Qualifier("defaultCurrencyFormat")
    private NumberFormat nf;

    @Test
    public void defaultCurrency() {
        double amount = 12345678.901234;
        System.out.println(nf.format(amount));
    }

    @Test
    public void germanCurrency() {
        double amount = 12345678.901234;
        NumberFormat deutschNF = ctx.getBean("germanCurrencyFormat", NumberFormat.class);
        System.out.println(deutschNF.format(amount));
    }

    @Test
    public void contextLoads() {
        int count = ctx.getBeanDefinitionCount();
        System.out.printf("There are " + count + " beans in the application context");

        for (String name : ctx.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

}
