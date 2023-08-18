package com.springboot;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import com.springboot.entity.User;
// import com.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityUserDetailsAuthApplication implements CommandLineRunner {

	// @Autowired
	// private UserRepository userRepository;

	// @Autowired
	// private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityUserDetailsAuthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// User user = new User();
		// user.setUsername("darshan");
		// user.setUserId(1);
		// user.setPassword(this.bCryptPasswordEncoder.encode("darshan@123"));
		// user.setRole("ROLE_ADMIN");	
		// this.userRepository.save(user);	
	}

}
