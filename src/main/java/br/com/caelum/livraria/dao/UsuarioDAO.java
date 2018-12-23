package br.com.caelum.livraria.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.caelum.livraria.modelo.Usuario;

@Repository
public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	EntityManager manager;
	
	public boolean existe(Usuario usuario) {
		
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u "
				+ " where u.email = :pEmail and u.senha = :pSenha", Usuario.class);
		
		query.setParameter("pEmail", usuario.getEmail());
		query.setParameter("pSenha", usuario.getSenha());
		
		Usuario result = null;
		
		try {
			result = query.getSingleResult();
		} catch(NoResultException ex) {
			return false;
		}
		
		return result != null;
		
	}
	
}
