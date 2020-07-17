package web.util;

import web.model.Role;

import java.util.Set;

public interface UtilService {
    public Set<Role> getRoleForUser(String role);
}
