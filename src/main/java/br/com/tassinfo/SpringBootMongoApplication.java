package br.com.tassinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tassinfo.domain.Cliente;
import br.com.tassinfo.repository.ClienteRepository;

@SpringBootApplication
public class SpringBootMongoApplication implements CommandLineRunner 
{
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		clienteRepository.deleteAll();

		// save a couple of customers
		clienteRepository.save(new Cliente("Jenifer", "jenifer@email.com"));
		clienteRepository.save(new Cliente("Renato", "renato@email.com"));

		// fetch all customers
		System.out.println("Clientes encontrados com findAll():");
		System.out.println("-------------------------------");
		for (Cliente cliente : clienteRepository.findAll()) {
			System.out.println(cliente);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Clientes encontrados com findByNome('Jenifer'):");
		System.out.println("--------------------------------");
		System.out.println(clienteRepository.findByNome("Jenifer"));
		System.out.println();

		System.out.println("Clientes encontrados com findByEmail('renato@email.com'):");
		System.out.println("--------------------------------");
		for (Cliente customer : clienteRepository.findByEmail("renato@email.com")) {
			System.out.println(customer);
		}
		System.out.println();
		
	}
}
