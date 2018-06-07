/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

import entities.users.Funcionarios;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Fleitas
 */
@Entity
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findById", query = "SELECT r FROM Respuesta r WHERE r.id = :id")
    , @NamedQuery(name = "Respuesta.findByFecha", query = "SELECT r FROM Respuesta r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Respuesta.findByNumero", query = "SELECT r FROM Respuesta r WHERE r.numero = :numero")
    , @NamedQuery(name = "Respuesta.findByDirigidoa", query = "SELECT r FROM Respuesta r WHERE r.dirigidoa = :dirigidoa")
    , @NamedQuery(name = "Respuesta.findByAsunto", query = "SELECT r FROM Respuesta r WHERE r.asunto = :asunto")
    , @NamedQuery(name = "Respuesta.findByRedaccion", query = "SELECT r FROM Respuesta r WHERE r.redaccion = :redaccion")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dirigidoa")
    private String dirigidoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "redaccion")
    private String redaccion;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionario;
    @JoinColumn(name = "idSeguimiento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seguimiento idSeguimiento;
    @JoinColumn(name = "idTipodoc", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodocumento idTipodoc;

    public Respuesta() {
    }

    public Respuesta(Long id) {
        this.id = id;
    }

    public Respuesta(Long id, Date fecha, String numero, String dirigidoa, String asunto, String redaccion) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.dirigidoa = dirigidoa;
        this.asunto = asunto;
        this.redaccion = redaccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDirigidoa() {
        return dirigidoa;
    }

    public void setDirigidoa(String dirigidoa) {
        this.dirigidoa = dirigidoa;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getRedaccion() {
        return redaccion;
    }

    public void setRedaccion(String redaccion) {
        this.redaccion = redaccion;
    }

    public Funcionarios getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionarios idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Tipodocumento getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(Tipodocumento idTipodoc) {
        this.idTipodoc = idTipodoc;
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
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Respuesta[ id=" + id + " ]";
    }
    
}
