package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override

    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT e FROM User e", User.class).getResultList();
    }

    @Override
    public void addRole(Role role){
        entityManager.persist(role);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public boolean isNotReg(String email) {
        return getAllUser()
                .stream()
                .anyMatch((e) -> e.getEmail().equals(email));
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByName(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1")
                .setParameter(1, email);
        List<User> list = (List<User>) query.getResultList();
        return list.get(0);
    }

    @Override
    public User getUserById(Long id) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.id = ?1")
                .setParameter(1, id).getSingleResult();
    }

    @Override
    public Role getRoleByName(String name) {
        return (Role) entityManager.createQuery("SELECT u FROM Role u WHERE u.name =?1")
                .setParameter(1, name).getSingleResult();
    }
}
