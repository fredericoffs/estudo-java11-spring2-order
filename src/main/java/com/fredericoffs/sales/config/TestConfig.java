package com.fredericoffs.sales.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fredericoffs.sales.entities.Category;
import com.fredericoffs.sales.entities.Order;
import com.fredericoffs.sales.entities.User;
import com.fredericoffs.sales.entities.enums.OrderStatus;
import com.fredericoffs.sales.repositories.CategoryRepository;
import com.fredericoffs.sales.repositories.OrderRepository;
import com.fredericoffs.sales.repositories.UserRepository;

//Classe específica de configuração para o perfil de teste
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// injeção de dependencia
	@Autowired
	private UserRepository userRepositoy;

	@Autowired
	private OrderRepository orderRepositoy;

	@Autowired
	private CategoryRepository categoryRepository;

	// Tudo que foz colocado dentro deste método será executado quando a app for
	// iniciada
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// salvando dentro do banco de dados
		// saveAll salva uma lista de obj
		userRepositoy.saveAll(Arrays.asList(u1, u2));

		// string com padrão de horário UTC "2019-06-20T19:53:07Z"
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, u1);

		orderRepositoy.saveAll(Arrays.asList(o1, o2, o3));

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

	}

}
