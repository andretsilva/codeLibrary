package br.ifsp.codelibrary.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.ifsp.codelibrary.entities.User;

public class UserRepository {
	private EntityManager manager ;
	
	public UserRepository (EntityManager manager ) {
		this.manager = manager ;
	}
	
	public void adiciona (User user) {
		this.manager.persist(user);
	}
	
	public User busca (int id) {
		return this.manager.find (User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List <User> buscaTodas() {
		Query query = this.manager.createQuery(" SELECT user FROM User user");
		return query.getResultList();
	}

}
