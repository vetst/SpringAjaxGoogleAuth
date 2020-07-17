package web.dao;

import web.model.Role;
import web.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    public List<User> getAllUser();

    public void addUser(User user);

    public void addRole(Role role);

    public void updateUser(User user);

    public void deleteUser(Long id);

    public boolean isNotReg(String email);

    public User getUserByName(String email);

    public User getUserById(Long id);

    public Role getRoleByName(String name);
}
