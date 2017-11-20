/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.service;

import java.util.ArrayList;
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
import service.Transacao;

/**
 *
 * @author roseanealves
 */
@Stateless
@Path("service.transacao")
public class TransacaoFacadeREST extends AbstractFacade<Transacao> {

    @PersistenceContext(unitName = "RESTRoseBankPU")
    private EntityManager em;

    public TransacaoFacadeREST() {
        super(Transacao.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Transacao entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Transacao entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Transacao find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transacao> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Transacao> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("usuario/{user}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacao> findTransactionByUser(@PathParam("user") Integer userId) {
        Query query = getEntityManager()
                .createNamedQuery("Transacao.findByIdUsuario")
                .setParameter("usuarioId", userId);
        
        if (query.getResultList().size() > 0) {
            return query.getResultList();
        } 
        return new ArrayList<>();
    }
    
    @GET
    @Path("conta/{account}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Transacao> findTransactionByAccount(@PathParam("account") Integer accountId) {
        Query query = getEntityManager()
                .createNamedQuery("Transacao.findByContaOrigem")
                .setParameter("contaOrigem", accountId);
        
        if (query.getResultList().size() > 0) {
            return query.getResultList();
        } 
        return new ArrayList<>();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
