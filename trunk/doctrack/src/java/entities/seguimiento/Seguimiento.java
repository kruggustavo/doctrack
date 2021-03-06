/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucas Fleitas
 */
@Entity
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findById", query = "SELECT s FROM Seguimiento s WHERE s.id = :id")
    , @NamedQuery(name = "Seguimiento.findByFechaentrada", query = "SELECT s FROM Seguimiento s WHERE s.fechaentrada = :fechaentrada")
    , @NamedQuery(name = "Seguimiento.findByFechasalido", query = "SELECT s FROM Seguimiento s WHERE s.fechasalido = :fechasalido")
    , @NamedQuery(name = "Seguimiento.findByEstadogeneral", query = "SELECT s FROM Seguimiento s WHERE s.estadogeneral = :estadogeneral")
    , @NamedQuery(name = "Seguimiento.findByDescripcion", query = "SELECT s FROM Seguimiento s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "Seguimiento.findByNuevoCampo", query = "SELECT s FROM Seguimiento s WHERE s.nuevoCampo = :nuevoCampo")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaentrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasalido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estadogeneral")
    private String estadogeneral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "NuevoCampo")
    private String nuevoCampo;
    @JoinColumn(name = "idDocumento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Documentos idDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSeguimiento")
    private Collection<Respuesta> respuestaCollection;

    public Seguimiento() {
    }

    public Seguimiento(Long id) {
        this.id = id;
    }

    public Seguimiento(Long id, Date fechaentrada, Date fechasalido, String estadogeneral, String descripcion, String nuevoCampo) {
        this.id = id;
        this.fechaentrada = fechaentrada;
        this.fechasalido = fechasalido;
        this.estadogeneral = estadogeneral;
        this.descripcion = descripcion;
        this.nuevoCampo = nuevoCampo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalido() {
        return fechasalido;
    }

    public void setFechasalido(Date fechasalido) {
        this.fechasalido = fechasalido;
    }

    public String getEstadogeneral() {
        return estadogeneral;
    }

    public void setEstadogeneral(String estadogeneral) {
        this.estadogeneral = estadogeneral;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNuevoCampo() {
        return nuevoCampo;
    }

    public void setNuevoCampo(String nuevoCampo) {
        this.nuevoCampo = nuevoCampo;
    }

    public Documentos getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documentos idDocumento) {
        this.idDocumento = idDocumento;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
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
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Seguimiento[ id=" + id + " ]";
    }
    
}
