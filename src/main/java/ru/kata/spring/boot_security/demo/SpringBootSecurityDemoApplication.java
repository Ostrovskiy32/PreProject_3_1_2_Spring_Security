package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

=======
import ru.kata.spring.boot_security.demo.repositories.RoleRepositoriesImpl;
import ru.kata.spring.boot_security.demo.repositories.UserRepositoriesImpl;
>>>>>>> 6435524 (first commit)


@SpringBootApplication
public class SpringBootSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
<<<<<<< HEAD
	}
=======
		UserRepositoriesImpl userRepositories = new UserRepositoriesImpl();
		RoleRepositoriesImpl roleRepositories = new RoleRepositoriesImpl();
//		userRepositories.initUser();
//		roleRepositories.initRole();
	}

>>>>>>> 6435524 (first commit)
}
