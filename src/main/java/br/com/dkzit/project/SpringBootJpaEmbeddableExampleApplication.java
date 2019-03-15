package br.com.dkzit.project;

import br.com.dkzit.project.model.Address;
import br.com.dkzit.project.model.NameDetails;
import br.com.dkzit.project.model.User;
import br.com.dkzit.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaEmbeddableExampleApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaEmbeddableExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Cleanup the user table
		userRepository.deleteAllInBatch();

		// Inser a new user in the database
		NameDetails nameDetails = new NameDetails("Alex", "Sandro");
		Address address = new Address("500", "Av. Sete Setembro", "Curitiba", "Paraná", "Brasil", "834050100");
		User user = new User(nameDetails, "alex_s_anstacio@hotmail.com", address);

		userRepository.save(user);
	}
}
