/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

import entities.institucion.Superviciones;
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
@Table(name = "documentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentos.findAll", query = "SELECT d FROM Documentos d")
    , @NamedQuery(name = "Documentos.findById", query = "SELECT d FROM Documentos d WHERE d.id = :id")
    , @NamedQuery(name = "Documentos.findByDescripcion", query = "SELECT d FROM Documentos d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "Documentos.findByFechaentrada", query = "SELECT d FROM Documentos d WHERE d.fechaentrada = :fechaentrada")
    , @NamedQuery(name = "Documentos.findByObservacion", query = "SELECT d FROM Documentos d WHERE d.observacion = :observacion")
    , @NamedQuery(name = "Documentos.findByNumeroDoc", query = "SELECT d FROM Documentos d WHERE d.numeroDoc = :numeroDoc")})
public class Documentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaentrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numero_doc")
    private String numeroDoc;
    @JoinColumn(name = "idSupervicion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Superviciones idSupervicion;
    @JoinColumn(name = "idTramitante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tramitantes idTramitante;

    public Documentos() {
    }

    public Documentos(Long id) {
        this.id = id;
    }

    public Documentos(Long id, String descripcion, Date fechaentrada, String observacion, String numeroDoc) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaentrada = fechaentrada;
        this.observacion = observacion;
        this.numeroDoc = numeroDoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public Superviciones getIdSupervicion() {
        return idSupervicion;
    }

    public void setIdSupervicion(Superviciones idSupervicion) {
        this.idSupervicion = idSupervicion;
    }

    public Tramitantes getIdTramitante() {
        return idTramitante;
    }

    public void setIdTramitante(Tramitantes idTramitante) {
        this.idTramitante = idTramitante;
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
        if (!(object instanceof Documentos)) {
            return false;
        }
        Documentos other = (Documentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Documentos[ id=" + id + " ]";
    }
    
}
