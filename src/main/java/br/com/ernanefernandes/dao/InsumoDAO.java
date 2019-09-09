package br.com.ernanefernandes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ernanefernandes.modelo.Usuario;

public class InsumoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	@Inject
	public InsumoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public InsumoDAO buscarPeloCodigo(String nome) {
		return this.manager.find(InsumoDAO.class, nome);
	}

	public List<InsumoDAO> buscarTodos() {
		return this.manager.createQuery("from Insumo").getResultList();
	}
	
}
