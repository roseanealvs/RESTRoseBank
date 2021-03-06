/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.Usuario;

/**
 *
 * @author roseanealves
 */
@Stateless
@Path("service.usuario")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "RESTRoseBankPU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Usuario entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{login}/{senha}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public Usuario findUserByLoginAndPassword(@PathParam("login") String login, @PathParam("senha") String senha) {
        Query query = getEntityManager()
                .createNamedQuery("Usuario.findByLoginAndPassword")
                .setParameter("login", login)
                .setParameter("senha", senha);
        
        if (query.getResultList().size() > 0) {
            return (Usuario)query.getResultList().get(0);
        } 
        return new Usuario();
    }

    @GET
    @Path("email/{email}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public Usuario findUserByEmail(@PathParam("email") String email) {
        Query query = getEntityManager()
                .createNamedQuery("Usuario.findByEmail")
                .setParameter("email", email);
        
        if (query.getResultList().size() > 0) {
            return (Usuario)query.getResultList().get(0);
        } 
        return new Usuario();
    }
     
    @GET
    @Path("login/{login}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public Usuario findUserByLogin(@PathParam("login") String login) {
        Query query = getEntityManager()
                .createNamedQuery("Usuario.findByLogin")
                .setParameter("login", login);
        if (query.getResultList().size() > 0) {
            return (Usuario)query.getResultList().get(0);
        } 
        return new Usuario();
    }
     
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
