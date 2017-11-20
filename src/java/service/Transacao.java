/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roseanealves
 */
@Entity
@Table(name = "transacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacao.findAll", query = "SELECT t FROM Transacao t"),
    @NamedQuery(name = "Transacao.findById", query = "SELECT t FROM Transacao t WHERE t.id = :id"),
    @NamedQuery(name = "Transacao.findByDsTransacao", query = "SELECT t FROM Transacao t WHERE t.dsTransacao = :dsTransacao"),
    @NamedQuery(name = "Transacao.findByDataTransacao", query = "SELECT t FROM Transacao t WHERE t.dataTransacao = :dataTransacao"),
    @NamedQuery(name = "Transacao.findByValor", query = "SELECT t FROM Transacao t WHERE t.valor = :valor"),
    @NamedQuery(name = "Transacao.findByContaOrigem", query = "SELECT t FROM Transacao t WHERE t.contaOrigem = :contaOrigem"),
    @NamedQuery(name = "Transacao.findByIdUsuario", query = "SELECT t FROM Transacao t WHERE t.usuarioId = :usuarioId")})
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 10)
    @Column(name = "ds_transacao")
    private String dsTransacao;
    @Size(max = 11)
    @Column(name = "data_transacao")
    private String dataTransacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "conta_origem")
    private Integer contaOrigem;
  
    @Column(name = "id_usuario")
    private Integer usuarioId;
    @Column(name = "tipo_transacao")
    private String tipoTransacao;
    public Transacao() {
    }

    public Transacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsTransacao() {
        return dsTransacao;
    }

    public void setDsTransacao(String dsTransacao) {
        this.dsTransacao = dsTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Integer contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service.Transacao[ id=" + id + " ]";
    }

    /**
     * @return the usuarioId
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return the dataTransacao
     */
    public String getDataTransacao() {
        return dataTransacao;
    }

    /**
     * @param dataTransacao the dataTransacao to set
     */
    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    /**
     * @return the tipoTransacao
     */
    public String getTipoTransacao() {
        return tipoTransacao;
    }

    /**
     * @param tipoTransacao the tipoTransacao to set
     */
    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
    
}
