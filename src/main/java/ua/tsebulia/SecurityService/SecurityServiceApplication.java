package ua.tsebulia.SecurityService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.tsebulia.SecurityService.domain.Role;
import ua.tsebulia.SecurityService.domain.User;
import ua.tsebulia.SecurityService.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveUser(new User(null, "John Doe", "john", "1212", new ArrayList<>()));
			userService.saveUser(new User(null, "Bob Black", "bob", "01001", new ArrayList<>()));
			userService.saveUser(new User(null, "Tom Cruise", "tom", "1111", new ArrayList<>()));
			userService.saveUser(new User(null, "Dan Caller", "dan", "9999", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("bob", "ROLE_MANAGER");
			userService.addRoleToUser("tom", "ROLE_ADMIN");
			userService.addRoleToUser("dan", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("dan", "ROLE_ADMIN");
			userService.addRoleToUser("dan", "ROLE_USER");
		};
	}

}
