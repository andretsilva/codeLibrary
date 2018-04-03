package br.ifsp.codelibrary.bean;

import java.io.Serializable;
 
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ifsp.codelibrary.entities.User; 
import br.ifsp.codelibrary.repository.UserRepository;
 
@ManagedBean
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome, email, telefone, senha, apelido;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	} 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	


	public String cadastrarUser(){
		
		User us = new User();
		us.setNome(nome);
		us.setEmail(email);
		us.setTelefone(telefone);
		us.setSenha(senha);
		us.setApelido(apelido);
		
		
		EntityManagerFactory factory =  
		  Persistence.createEntityManagerFactory("codelibrary");
		
		EntityManager manager = factory.createEntityManager();
		
		UserRepository editoraRepository = 
			new UserRepository(manager);
		
		manager.getTransaction().begin();
		
		editoraRepository.adiciona(us);
		
		manager.getTransaction().commit(); 
		
		factory.close();
		
		System.out.println("Nome: " + nome);
		System.out.println("E-mail: " + email);
		
		
		return "RespostaUser";
	}
}