package web.dao;

import web.model.User;

import java.util.List;

public interface CrudDao {

    List<User> getAllUser();

    boolean addUser(String name, String telephone);

    boolean editUser(User user);

    boolean deleteUser(User user);

    boolean searchUser(String name, String password);

    User returnUser(String name, String password);

}
