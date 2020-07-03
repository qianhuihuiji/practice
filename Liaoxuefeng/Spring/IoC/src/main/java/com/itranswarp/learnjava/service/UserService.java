package com.itranswarp.learnjava.service;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author nofirst
 * @date 2020-07-03 14:52
 */
public class UserService {
    private MailService mailService;

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    private List<User> users = setUsers();

    private List<User> setUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "bob@example.com", "password", "Bob"));
        users.add(new User(2L, "alice@example.com", "password", "Alice"));
        users.add(new User(3L, "tom@example.com", "password", "Tom"));

        return users;
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed.");
    }

    public User getUser(long id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(RuntimeException::new);
    }

    public User register(String email, String password, String name) {
        users.forEach((user) -> {
            if (user.getEmail().equalsIgnoreCase(email)) {
                throw new RuntimeException("email exist.");
            }
        });
        User user = new User(users.stream().mapToLong(u -> u.getId()).max().getAsLong(), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
