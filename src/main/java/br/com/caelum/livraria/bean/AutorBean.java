package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Controller
public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Autor autor = new Autor();
	
	@Inject
	private AutorDao dao;
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	@Transactional
	public void gravar() {
		
		if(this.autor.getId() == null) {
			dao.adiciona(this.autor);
		} else {
			dao.atualiza(this.autor);
		}
		
		this.autor = new Autor();

	}
	
	public List<Autor> getAutores() {
		return dao.listaTodos();
	}
	
	@Transactional
	public void excluir(Autor autor) {
		dao.remove(autor);
		FacesContext.getCurrentInstance().addMessage("frmAutor", new FacesMessage("Autor excluído com sucesso!"));
	}
}
