package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.caelum.livraria.modelo.Venda;

@Repository
public class VendasDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager manager;
	
	public List<Venda> listarTodos() {
		TypedQuery<Venda> query = manager.createQuery("select v from Venda v", Venda.class);
		return query.getResultList();
	}
	
}
