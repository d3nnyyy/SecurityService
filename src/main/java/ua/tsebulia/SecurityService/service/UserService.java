package ua.tsebulia.SecurityService.service;

import ua.tsebulia.SecurityService.domain.Role;
import ua.tsebulia.SecurityService.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
