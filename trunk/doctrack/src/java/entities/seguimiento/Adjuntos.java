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
 * @author Lucas Fleitas
 */
@Entity
@Table(name = "adjuntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adjuntos.findAll", query = "SELECT a FROM Adjuntos a")
    , @NamedQuery(name = "Adjuntos.findByNombredocAdj", query = "SELECT a FROM Adjuntos a WHERE a.nombredocAdj = :nombredocAdj")
    , @NamedQuery(name = "Adjuntos.findById", query = "SELECT a FROM Adjuntos a WHERE a.id = :id")})
public class Adjuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombredoc_adj")
    private String nombredocAdj;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "idTipodoc", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipodocumento idTipodoc;
    @JoinColumn(name = "idDocumento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Documentos idDocumento;

    public Adjuntos() {
    }

    public Adjuntos(Long id) {
        this.id = id;
    }

    public Adjuntos(Long id, String nombredocAdj) {
        this.id = id;
        this.nombredocAdj = nombredocAdj;
    }

    public String getNombredocAdj() {
        return nombredocAdj;
    }

    public void setNombredocAdj(String nombredocAdj) {
        this.nombredocAdj = nombredocAdj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipodocumento getIdTipodoc() {
        return idTipodoc;
    }

    public void setIdTipodoc(Tipodocumento idTipodoc) {
        this.idTipodoc = idTipodoc;
    }

    public Documentos getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documentos idDocumento) {
        this.idDocumento = idDocumento;
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
        if (!(object instanceof Adjuntos)) {
            return false;
        }
        Adjuntos other = (Adjuntos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.seguimiento.Adjuntos[ id=" + id + " ]";
    }
    
}
