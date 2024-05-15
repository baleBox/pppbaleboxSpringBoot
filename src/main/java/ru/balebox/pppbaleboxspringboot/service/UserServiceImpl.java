package ru.balebox.pppbaleboxspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.balebox.pppbaleboxspringboot.model.User;
import ru.balebox.pppbaleboxspringboot.repository.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> getAllUsers(String userlist) {
        return userDao.getAllUsers(userlist);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void editUser(User newDataUser) {
        userDao.editUser(newDataUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user=userDao.getUserById(id);
        userDao.deleteUser(user.getId());
    }
}
