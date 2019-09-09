package br.com.ernanefernandes.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.ernanefernandes.modelo.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager manager;

	@Inject
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public UsuarioDAO buscarPeloCodigo(String nome) {
		return this.manager.find(UsuarioDAO.class, nome);
	}

	public List<UsuarioDAO> buscarTodos() {
		return this.manager.createQuery("from Usuario").getResultList();
	}
	
}
