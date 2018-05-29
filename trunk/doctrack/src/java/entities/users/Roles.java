/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.users;

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
 * @author usuario
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")
    , @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id")
    , @NamedQuery(name = "Roles.findByDescripcion", query = "SELECT r FROM Roles r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Roles.findByIngresadocumentos", query = "SELECT r FROM Roles r WHERE r.ingresadocumentos = :ingresadocumentos")
    , @NamedQuery(name = "Roles.findByTransferirdocumentos", query = "SELECT r FROM Roles r WHERE r.transferirdocumentos = :transferirdocumentos")
    , @NamedQuery(name = "Roles.findByCambiarestado", query = "SELECT r FROM Roles r WHERE r.cambiarestado = :cambiarestado")
    , @NamedQuery(name = "Roles.findByCerrarestado", query = "SELECT r FROM Roles r WHERE r.cerrarestado = :cerrarestado")
    , @NamedQuery(name = "Roles.findByGenerarresoluciones", query = "SELECT r FROM Roles r WHERE r.generarresoluciones = :generarresoluciones")
    , @NamedQuery(name = "Roles.findByVisualizarinformes", query = "SELECT r FROM Roles r WHERE r.visualizarinformes = :visualizarinformes")
    , @NamedQuery(name = "Roles.findByAdministraconfiguraciones", query = "SELECT r FROM Roles r WHERE r.administraconfiguraciones = :administraconfiguraciones")})
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Ingresa_documentos")
    private String ingresadocumentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Transferir_documentos")
    private String transferirdocumentos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Cambiar_estado")
    private String cambiarestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Cerrar_estado")
    private String cerrarestado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Generar_resoluciones")
    private String generarresoluciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Visualizar_informes")
    private String visualizarinformes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Administra_configuraciones")
    private String administraconfiguraciones;

    public Roles() {
    }

    public Roles(Integer id) {
        this.id = id;
    }

    public Roles(Integer id, String descripcion, String ingresadocumentos, String transferirdocumentos, String cambiarestado, String cerrarestado, String generarresoluciones, String visualizarinformes, String administraconfiguraciones) {
        this.id = id;
        this.descripcion = descripcion;
        this.ingresadocumentos = ingresadocumentos;
        this.transferirdocumentos = transferirdocumentos;
        this.cambiarestado = cambiarestado;
        this.cerrarestado = cerrarestado;
        this.generarresoluciones = generarresoluciones;
        this.visualizarinformes = visualizarinformes;
        this.administraconfiguraciones = administraconfiguraciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngresadocumentos() {
        return ingresadocumentos;
    }

    public void setIngresadocumentos(String ingresadocumentos) {
        this.ingresadocumentos = ingresadocumentos;
    }

    public String getTransferirdocumentos() {
        return transferirdocumentos;
    }

    public void setTransferirdocumentos(String transferirdocumentos) {
        this.transferirdocumentos = transferirdocumentos;
    }

    public String getCambiarestado() {
        return cambiarestado;
    }

    public void setCambiarestado(String cambiarestado) {
        this.cambiarestado = cambiarestado;
    }

    public String getCerrarestado() {
        return cerrarestado;
    }

    public void setCerrarestado(String cerrarestado) {
        this.cerrarestado = cerrarestado;
    }

    public String getGenerarresoluciones() {
        return generarresoluciones;
    }

    public void setGenerarresoluciones(String generarresoluciones) {
        this.generarresoluciones = generarresoluciones;
    }

    public String getVisualizarinformes() {
        return visualizarinformes;
    }

    public void setVisualizarinformes(String visualizarinformes) {
        this.visualizarinformes = visualizarinformes;
    }

    public String getAdministraconfiguraciones() {
        return administraconfiguraciones;
    }

    public void setAdministraconfiguraciones(String administraconfiguraciones) {
        this.administraconfiguraciones = administraconfiguraciones;
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
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.users.Roles[ id=" + id + " ]";
    }
    
}
