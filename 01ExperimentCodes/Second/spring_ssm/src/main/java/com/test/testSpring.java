package com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.service.userService;
public class testSpring {
    @Test
    public void testService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        userService service = (userService) ac.getBean("userService");
        System.out.println();
    }

}
