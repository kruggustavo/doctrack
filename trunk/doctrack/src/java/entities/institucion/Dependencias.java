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
<<<<<<< HEAD
 * @author usuario
=======
 * @author Lucas Fleitas
>>>>>>> correccion de error al ejecutar
 */

@Entity
@Table(name = "dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencias.findAll", query = "SELECT d FROM Dependencias d")
    , @NamedQuery(name = "Dependencias.findById", query = "SELECT d FROM Dependencias d WHERE d.id = :id")
    , @NamedQuery(name = "Dependencias.findByNombre", query = "SELECT d FROM Dependencias d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Dependencias.findByEmail", query = "SELECT d FROM Dependencias d WHERE d.email = :email")
    , @NamedQuery(name = "Dependencias.findByInterno", query = "SELECT d FROM Dependencias d WHERE d.interno = :interno")})
public class Dependencias implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDependencia")
    private Collection<Gestiondocumentos> gestiondocumentosCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDependencia")
    private Collection<Areas> areasCollection;
    
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "interno")
    private String interno;

    public Dependencias() {
    }

    public Dependencias(Long id) {
        this.id = id;
    }

    public Dependencias(Long id, String nombre, String email, String interno) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.interno = interno;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInterno() {
        return interno;
    }

    public void setInterno(String interno) {
        this.interno = interno;
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
        if (!(object instanceof Dependencias)) {
            return false;
        }
        Dependencias other = (Dependencias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.institucion.Dependencias[ id=" + id + " ]";

        
    }

    @XmlTransient
    public Collection<Areas> getAreasCollection() {
        return areasCollection;
    }

    public void setAreasCollection(Collection<Areas> areasCollection) {
        this.areasCollection = areasCollection;
        
    }

    @XmlTransient
    public Collection<Gestiondocumentos> getGestiondocumentosCollection() {
        return gestiondocumentosCollection;
    }

    public void setGestiondocumentosCollection(Collection<Gestiondocumentos> gestiondocumentosCollection) {
        this.gestiondocumentosCollection = gestiondocumentosCollection;
    }
    
}
