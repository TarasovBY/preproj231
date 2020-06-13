package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CrudDaoImp implements CrudDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Transactional(readOnly = false)
    public boolean addUser(String name, String telephone) {
        try {
            sessionFactory.getCurrentSession().save(new User(name, telephone));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional(readOnly = false)
    public boolean editUser(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional(readOnly = false)
    public boolean deleteUser(User user) {
        int result = sessionFactory.getCurrentSession().createQuery("delete User where id = " + user.getId()).executeUpdate();
        return result > 0;
    }

    @Transactional(readOnly = true)
    public boolean searchUser(String name, String password) {
        int result = sessionFactory.getCurrentSession().
                createQuery("FROM User where name = '" + name + "'"
                        + " and password='" + password + "'").list().size();
        return result > 0;
    }

    @Transactional(readOnly = true)
    public User returnUser(String name, String password) {
        try {
            User user = (User) sessionFactory.getCurrentSession().createQuery("FROM User where name = '" + name + "'"
                    + " and password='" + password + "'").list().get(0);
            return sessionFactory.getCurrentSession().get(User.class, user.getId());
        } catch (Exception e) {
            return new User();
        }
    }
}
