/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

import entities.institucion.Areas;
import entities.institucion.Dependencias;
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
@Table(name = "gestiondocumentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gestiondocumentos.findAll", query = "SELECT g FROM Gestiondocumentos g")
    , @NamedQuery(name = "Gestiondocumentos.findById", query = "SELECT g FROM Gestiondocumentos g WHERE g.id = :id")
    , @NamedQuery(name = "Gestiondocumentos.findByFecha", query = "SELECT g FROM Gestiondocumentos g WHERE g.fecha = :fecha")
    , @NamedQuery(name = "Gestiondocumentos.findByAsunto", query = "SELECT g FROM Gestiondocumentos g WHERE g.asunto = :asunto")
    , @NamedQuery(name = "Gestiondocumentos.findByObservacion", query = "SELECT g FROM Gestiondocumentos g WHERE g.observacion = :observacion")
    , @NamedQuery(name = "Gestiondocumentos.findByEstadogestion", query = "SELECT g FROM Gestiondocumentos g WHERE g.estadogestion = :estadogestion")})
public class Gestiondocumentos implements Serializable {

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
    @Size(min = 1, max = 255)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "estadogestion")
    private String estadogestion;
    @JoinColumn(name = "idSeguimiento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Seguimiento idSeguimiento;
    @JoinColumn(name = "idDependencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dependencias idDependencia;
    @JoinColumn(name = "idArea", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Areas idArea;

    public Gestiondocumentos() {
    }

    public Gestiondocumentos(Long id) {
        this.id = id;
    }

    public Gestiondocumentos(Long id, Date fecha, String asunto, String observacion, String estadogestion) {
        this.id = id;
        this.fecha = fecha;
        this.asunto = asunto;
        this.observacion = observacion;
        this.estadogestion = estadogestion;
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadogestion() {
        return estadogestion;
    }

    public void setEstadogestion(String estadogestion) {
        this.estadogestion = estadogestion;
    }

    public Seguimiento getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Seguimiento idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Dependencias getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Dependencias idDependencia) {
        this.idDependencia = idDependencia;
    }

    public Areas getIdArea() {
        return idArea;
    }

    public void setIdArea(Areas idArea) {
        this.idArea = idArea;
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
        if (!(object instanceof Gestiondocumentos)) {
            return false;
        }
        Gestiondocumentos other = (Gestiondocumentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Gestiondocumentos[ id=" + id + " ]";
    }
    
}
