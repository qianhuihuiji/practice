package com.itranswarp.learnjava;

import com.itranswarp.learnjava.service.User;
import com.itranswarp.learnjava.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-07-03 14:45
 */
public class Main {
    @SuppressWarnings("resources")
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.getName());
    }
}
