package ua.tsebulia.SecurityService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tsebulia.SecurityService.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
