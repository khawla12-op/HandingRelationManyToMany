package ma.enset.jpaenset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "USERS")
//Le nom de la table doit differe de la classe
@Data
@NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private String userId;
    @Column(unique = true,length = 20,name="USER_NAME")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(mappedBy = "users",fetch= FetchType.EAGER)
    //Eager means that eaah time we load a user we load also the roles
    private List<Role> roles=new ArrayList<>();
    //IL faut initialiser la liste pour eviter les null pointer exception

}
