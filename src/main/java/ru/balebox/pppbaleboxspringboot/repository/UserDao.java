package ru.balebox.pppbaleboxspringboot.repository;

import ru.balebox.pppbaleboxspringboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers(String userlist);
    User getUserById(Long id);
    void addUser(User user);
    void editUser(User user,Long id);
    void deleteUser(Long id);
}
