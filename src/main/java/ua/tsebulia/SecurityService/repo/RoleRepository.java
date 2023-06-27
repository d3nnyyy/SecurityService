package ua.tsebulia.SecurityService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tsebulia.SecurityService.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
