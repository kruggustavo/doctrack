/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

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
@Table(name = "tramitantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramitantes.findAll", query = "SELECT t FROM Tramitantes t")
    , @NamedQuery(name = "Tramitantes.findById", query = "SELECT t FROM Tramitantes t WHERE t.id = :id")
    , @NamedQuery(name = "Tramitantes.findByNombreCompleto", query = "SELECT t FROM Tramitantes t WHERE t.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Tramitantes.findByDireccion", query = "SELECT t FROM Tramitantes t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Tramitantes.findByCi", query = "SELECT t FROM Tramitantes t WHERE t.ci = :ci")
    , @NamedQuery(name = "Tramitantes.findByTelefono", query = "SELECT t FROM Tramitantes t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Tramitantes.findByEmail", query = "SELECT t FROM Tramitantes t WHERE t.email = :email")})
public class Tramitantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ci")
    private String ci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTramitante")
    private Collection<Documentos> documentosCollection;

    public Tramitantes() {
    }

    public Tramitantes(Long id) {
        this.id = id;
    }

    public Tramitantes(Long id, String nombreCompleto, String direccion, String ci, String telefono, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.ci = ci;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Documentos> getDocumentosCollection() {
        return documentosCollection;
    }

    public void setDocumentosCollection(Collection<Documentos> documentosCollection) {
        this.documentosCollection = documentosCollection;
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
        if (!(object instanceof Tramitantes)) {
            return false;
        }
        Tramitantes other = (Tramitantes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Tramitantes[ id=" + id + " ]";
    }
    
}
