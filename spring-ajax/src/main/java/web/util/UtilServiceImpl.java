package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.Role;

import java.util.HashSet;
import java.util.Set;

@Component
public class UtilServiceImpl implements UtilService {

    private UserDao userDao;

    @Autowired
    public UtilServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Set<Role> getRoleForUser(String role) {
        Set<Role> roles = new HashSet<>();
        try {
            String[] partsRole = role.split("[, ]");
            roles.add(new Role(partsRole[1]));
            roles.add(new Role(partsRole[0]));
            return roles;
        } catch (Exception e) {

        }
        roles.add(new Role(role));
        return roles;
    }
}
