/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.institucion;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "distritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distritos.findAll", query = "SELECT d FROM Distritos d")
    , @NamedQuery(name = "Distritos.findById", query = "SELECT d FROM Distritos d WHERE d.id = :id")
    , @NamedQuery(name = "Distritos.findByNombre", query = "SELECT d FROM Distritos d WHERE d.nombre = :nombre")})
public class Distritos implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDistrito")
    private Collection<Superviciones> supervicionesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;

    public Distritos() {
    }

    public Distritos(Long id) {
        this.id = id;
    }

    public Distritos(Long id, String nombre) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distritos)) {
            return false;
        }
        Distritos other = (Distritos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.institucion.Distritos[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Superviciones> getSupervicionesCollection() {
        return supervicionesCollection;
    }

    public void setSupervicionesCollection(Collection<Superviciones> supervicionesCollection) {
        this.supervicionesCollection = supervicionesCollection;
    }
    
}
