package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.CrudDao;
import web.model.User;

import java.util.List;

@org.springframework.stereotype.Service
public class UserService implements Service {

    @Autowired
    CrudDao crudDao;

    @Override
    public List<User> getAllUser() {
        return crudDao.getAllUser();
    }

    @Override
    public boolean addUser(String name, String telephone) {
        return crudDao.addUser(name, telephone);
    }

    @Override
    public boolean editUser(User user) {
        return crudDao.editUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return crudDao.deleteUser(user);
    }

    @Override
    public boolean searchUser(String name, String password) {
        return crudDao.searchUser(name, password);
    }

    @Override
    public User returnUser(String name, String password) {
        return crudDao.returnUser(name, password);
    }
}
