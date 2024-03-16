package ma.enset.jpaenset;

import ma.enset.jpaenset.entities.Role;
import ma.enset.jpaenset.entities.User;
import ma.enset.jpaenset.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class JpaEnsetApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaEnsetApplication.class, args);

    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            User user=new User();
            user.setUsername("khaoula");
            user.setPassword("1234");
            userService.addNewUser(user);

            User user2=new User();
            user2.setUsername("admin");
            user2.setPassword("1234");
            userService.addNewUser(user2);
            Stream.of("STUDENT","USER","ADMIN").forEach(role->{
                Role role1=new Role();
                role1.setRoleName(role);
                userService.addNewRole(role1);
            });
            userService.addRoleToUser("khaoula","STUDENT");
            userService.addRoleToUser("khaoula","USER");
            userService.addRoleToUser("admin","ADMIN");
            userService.addRoleToUser("admin","USER");
            //Authentication
            try {
                user = userService.authenticate("khaoula", "1234");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());
                System.out.println("Roles =>");
                user.getRoles().forEach(role -> {
                    System.out.println("Role ->" +role.toString());
                });
            }
            catch (Exception e){
                e.printStackTrace();
            }



        };
    }


}
