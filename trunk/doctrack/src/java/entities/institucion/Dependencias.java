package entities.institucion;

import entities.institucion.Superviciones;
import java.io.Serializable;
import java.util.List;
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
 * @author Arza
 */
@Entity
@Table(name = "dependencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencias.findAll", query = "SELECT d FROM Dependencias d")
    , @NamedQuery(name = "Dependencias.findById", query = "SELECT d FROM Dependencias d WHERE d.id = :id")
    , @NamedQuery(name = "Dependencias.findByNombre", query = "SELECT d FROM Dependencias d WHERE d.nombre = :nombre")})
public class Dependencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Interno")
    private String interno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDependencias")
    private List<Superviciones> supervicionesList;

    public Dependencias() {
    }

    public Dependencias(Integer id) {
        this.id = id;
    }

    public Dependencias(Integer id, String nombre, String email, String interno) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.interno = interno;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    
    @XmlTransient
    public List<Superviciones> getSupervicionesList() {
        return supervicionesList;
    }

    public void setSupervicionesList(List<Superviciones> supervicionesList) {
        this.supervicionesList = supervicionesList;
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
        return "entities.Dependencias[ id=" + id + " ]";
    }
    
}