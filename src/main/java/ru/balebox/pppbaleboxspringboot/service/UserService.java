package ru.balebox.pppbaleboxspringboot.service;

import ru.balebox.pppbaleboxspringboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers(String userlist);

    User getUserById(Long id);

    void addUser(User user);

    void editUser(User user, Long id);

    void deleteUser(Long id);
}
