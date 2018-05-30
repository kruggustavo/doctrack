/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.institucion;

import entities.users.Funcionarios;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "superviciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Superviciones.findAll", query = "SELECT s FROM Superviciones s")
    , @NamedQuery(name = "Superviciones.findById", query = "SELECT s FROM Superviciones s WHERE s.id = :id")
    , @NamedQuery(name = "Superviciones.findByNumeroSupervision", query = "SELECT s FROM Superviciones s WHERE s.numeroSupervision = :numeroSupervision")
    , @NamedQuery(name = "Superviciones.findByDireccion", query = "SELECT s FROM Superviciones s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Superviciones.findByTelefono", query = "SELECT s FROM Superviciones s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "Superviciones.findByEmail", query = "SELECT s FROM Superviciones s WHERE s.email = :email")})
public class Superviciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero_supervision")
    private String numeroSupervision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionarios idFuncionario;
    @JoinColumn(name = "idDistrito", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Distritos idDistrito;

    public Superviciones() {
    }

    public Superviciones(Long id) {
        this.id = id;
    }

    public Superviciones(Long id, String numeroSupervision, String direccion, String telefono, String email) {
        this.id = id;
        this.numeroSupervision = numeroSupervision;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroSupervision() {
        return numeroSupervision;
    }

    public void setNumeroSupervision(String numeroSupervision) {
        this.numeroSupervision = numeroSupervision;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Funcionarios getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionarios idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Distritos getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(Distritos idDistrito) {
        this.idDistrito = idDistrito;
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
        if (!(object instanceof Superviciones)) {
            return false;
        }
        Superviciones other = (Superviciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.institucion.Superviciones[ id=" + id + " ]";
    }
    
}
