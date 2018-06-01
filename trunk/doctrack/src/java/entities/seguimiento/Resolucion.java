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
@Table(name = "resolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resolucion.findAll", query = "SELECT r FROM Resolucion r")
    , @NamedQuery(name = "Resolucion.findById", query = "SELECT r FROM Resolucion r WHERE r.id = :id")
    , @NamedQuery(name = "Resolucion.findByFecha", query = "SELECT r FROM Resolucion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Resolucion.findByNumero", query = "SELECT r FROM Resolucion r WHERE r.numero = :numero")
    , @NamedQuery(name = "Resolucion.findByResuelve", query = "SELECT r FROM Resolucion r WHERE r.resuelve = :resuelve")
    , @NamedQuery(name = "Resolucion.findByVisto", query = "SELECT r FROM Resolucion r WHERE r.visto = :visto")})
public class Resolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
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
    @Column(name = "resuelve")
    private String resuelve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "visto")
    private String visto;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionario;
    @JoinColumn(name = "idSeguimiento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seguimiento idSeguimiento;

    public Resolucion() {
    }

    public Resolucion(Long id) {
        this.id = id;
    }

    public Resolucion(Long id, Date fecha, String numero, String resuelve, String visto) {
        this.id = id;
        this.fecha = fecha;
        this.numero = numero;
        this.resuelve = resuelve;
        this.visto = visto;
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

    public String getResuelve() {
        return resuelve;
    }

    public void setResuelve(String resuelve) {
        this.resuelve = resuelve;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resolucion)) {
            return false;
        }
        Resolucion other = (Resolucion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Resolucion[ id=" + id + " ]";
    }
    
}
