package br.com.ernanefernandes.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import br.com.ernanefernandes.modelo.Insumos;



@Path("/insumo")
public class InsumoService implements Serializable{

	private static final long serialVersionUID = 1L;
	       
	private EntityManager objEM ;
	
	@Inject
	public InsumoService(EntityManager manager) {
		this.objEM = manager;
	}
	
	@GET
	@Path("/listar/")
	@Produces("application/json")
	public List<Insumos> listar(){                             

		try {
			String query = "select c from Insumos c ";
			List<Insumos> obj = objEM.createQuery(query, Insumos.class).getResultList();        
			objEM.close();                                  
			return obj;     
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@GET
	@Path("/buscar/")
	@Produces("application/json") 
	public Insumos buscar(@PathParam("id") int id){                       
		try {    
			Insumos obj = objEM.find(Insumos.class, id);
			objEM.close();                                        
			return obj;     
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@GET
	@Path("/buscarNome/")
	@Produces("application/json") 
	public Insumos buscarNome(@PathParam("nome")  String nome){                       
		try {    
			Insumos obj = objEM.find(Insumos.class, nome);
			objEM.close();                                        
			return obj;     
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	} 


	@POST
	@Path("/cadastrar/")
	@Consumes("application/json") 
	public Response cadastrar(Insumos obj){                                  
		try {
			objEM.getTransaction().begin();
			objEM.persist(obj);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro realizado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@PUT
	@Path("/alterar")
	@Consumes("application/json") 
	public Response alterar(Insumos obj){                                    
		try {
			objEM.getTransaction().begin();
			objEM.merge(obj);
			objEM.getTransaction().commit();
			objEM.close();
			return Response.status(200).entity("cadastro alterado.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}  
	}

	@DELETE
	@Path("/excluir/")
	public Response excluir(@PathParam("id") int id){      
		try {    
			Insumos obj = objEM.find(Insumos.class, id);

			objEM.getTransaction().begin();
			objEM.remove(obj);
			objEM.getTransaction().commit();
			objEM.close();

			return Response.status(200).entity("cadastro excluído.").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
}