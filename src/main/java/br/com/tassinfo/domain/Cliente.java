package br.com.tassinfo.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Cliente 
{
	@Id
	public String id;
	public String nome;
	public String email;
	
	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
}
