package com.fredericoffs.sales.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fredericoffs.sales.entities.User;
import com.fredericoffs.sales.repositories.UserRepository;

//Classe específica de configuração para o perfil de teste
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// injeção de dependencia
	@Autowired
	private UserRepository userRepositoy;

	// Tudo que foz colocado dentro deste método será executado quando a app for
	// iniciada
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// salvando dentro do banco de dados
		// saveAll salva uma lista de obj 
		userRepositoy.saveAll(Arrays.asList(u1, u2));

	}

}
