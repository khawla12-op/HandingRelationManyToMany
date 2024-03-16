package ma.enset.jpaenset.repositories;

import ma.enset.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
   Role findByRoleName(String roleName);
}
