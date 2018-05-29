/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.seguimiento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lucas Fleitas
 */
@Entity
@Table(name = "tipodocumento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodocumento.findAll", query = "SELECT t FROM Tipodocumento t")
    , @NamedQuery(name = "Tipodocumento.findById", query = "SELECT t FROM Tipodocumento t WHERE t.id = :id")
    , @NamedQuery(name = "Tipodocumento.findByNombre", query = "SELECT t FROM Tipodocumento t WHERE t.nombre = :nombre")})
public class Tipodocumento implements Serializable {

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

    public Tipodocumento() {
    }

    public Tipodocumento(Long id) {
        this.id = id;
    }

    public Tipodocumento(Long id, String nombre) {
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
        if (!(object instanceof Tipodocumento)) {
            return false;
        }
        Tipodocumento other = (Tipodocumento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Tipodocumento[ id=" + id + " ]";
    }
    
}
