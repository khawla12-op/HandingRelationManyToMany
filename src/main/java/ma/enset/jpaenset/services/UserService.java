package ma.enset.jpaenset.services;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String username, String password);
}
