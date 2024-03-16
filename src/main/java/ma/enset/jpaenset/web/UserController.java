package ma.enset.jpaenset.web;

import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {
    private UserService userService;
    //Pour consulter la liste des utilisateurs
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user =userService.findUserByUsername(username);
        return user;
    }

}
