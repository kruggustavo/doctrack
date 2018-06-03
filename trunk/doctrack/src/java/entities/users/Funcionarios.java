/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.users;

import entities.institucion.Superviciones;
import entities.seguimiento.Respuesta;
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
 * @author usuario
 */
@Entity
@Table(name = "funcionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarios.findAll", query = "SELECT f FROM Funcionarios f")
    , @NamedQuery(name = "Funcionarios.findById", query = "SELECT f FROM Funcionarios f WHERE f.id = :id")
    , @NamedQuery(name = "Funcionarios.findByNombreCompleto", query = "SELECT f FROM Funcionarios f WHERE f.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "Funcionarios.findByDireccion", query = "SELECT f FROM Funcionarios f WHERE f.direccion = :direccion")
    , @NamedQuery(name = "Funcionarios.findByCi", query = "SELECT f FROM Funcionarios f WHERE f.ci = :ci")
    , @NamedQuery(name = "Funcionarios.findByTelefono", query = "SELECT f FROM Funcionarios f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Funcionarios.findByEmail", query = "SELECT f FROM Funcionarios f WHERE f.email = :email")})
public class Funcionarios implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<Superviciones> supervicionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<Respuesta> respuestaCollection;

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
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 50)
    @Column(name = "ci")
    private String ci;
    @Size(max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;

    public Funcionarios() {
    }

    public Funcionarios(Long id) {
        this.id = id;
    }

    public Funcionarios(Long id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionarios)) {
            return false;
        }
        Funcionarios other = (Funcionarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.users.Funcionarios[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Superviciones> getSupervicionesCollection() {
        return supervicionesCollection;
    }

    public void setSupervicionesCollection(Collection<Superviciones> supervicionesCollection) {
        this.supervicionesCollection = supervicionesCollection;
    }

    @XmlTransient
    public Collection<Respuesta> getRespuestaCollection() {
        return respuestaCollection;
    }

    public void setRespuestaCollection(Collection<Respuesta> respuestaCollection) {
        this.respuestaCollection = respuestaCollection;
    }
    
}
