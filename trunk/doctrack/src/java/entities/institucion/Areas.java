/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.institucion;

import entities.seguimiento.Gestiondocumentos;
import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lucas Fleitas
 */
@Entity
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")
    , @NamedQuery(name = "Areas.findById", query = "SELECT a FROM Areas a WHERE a.id = :id")
    , @NamedQuery(name = "Areas.findByNombre", query = "SELECT a FROM Areas a WHERE a.nombre = :nombre")})
public class Areas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArea")
    private Collection<Gestiondocumentos> gestiondocumentosCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idDependencia", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dependencias idDependencia;

    public Areas() {
    }

    public Areas(Long id) {
        this.id = id;
    }

    public Areas(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dependencias getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Dependencias idDependencia) {
        this.idDependencia = idDependencia;
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
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.institucion.Areas[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Gestiondocumentos> getGestiondocumentosCollection() {
        return gestiondocumentosCollection;
    }

    public void setGestiondocumentosCollection(Collection<Gestiondocumentos> gestiondocumentosCollection) {
        this.gestiondocumentosCollection = gestiondocumentosCollection;
    }
    
}
