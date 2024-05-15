package ru.balebox.pppbaleboxspringboot.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.balebox.pppbaleboxspringboot.controllers.UserNotFoundException;
import ru.balebox.pppbaleboxspringboot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers(String userlist) {
        return entityManager.createQuery("From User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);

        if (user == null)
            throw new UserNotFoundException(String.format("пользователь с id=%d не найден", id));

        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(User newDataUser) {
        entityManager.merge(newDataUser);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserById(id));
    }
}
