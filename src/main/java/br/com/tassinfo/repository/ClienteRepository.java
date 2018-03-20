package br.com.tassinfo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tassinfo.domain.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>
{
	public Cliente findByNome(String nome);
	public List<Cliente> findByEmail(String email);
}
