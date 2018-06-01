/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.TramitantesController;
import entities.seguimiento.Tramitantes;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Lucas Fleitas
 */
@ManagedBean
@SessionScoped
public class TramitantesBean implements Serializable {
    private static final long serialVersionUID = 5908481450734539L;

    private String nombreCompleto;
    private String direccion;
    private String ci;
    private String telefono;
    private String email;
    private List<Tramitantes> tramitantesList;
    private Tramitantes tramitantes;
    private final TramitantesController controller = new TramitantesController();

    public void guardarTramitante()
    {
        try
        {
            controller.saveTramitantes(tramitantes);
            tramitantes = null;//destruyo el objeto
        }
        catch(Exception e)
        {
            System.out.println("error save controller "+e);
        }
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

    public List<Tramitantes> getTramitantesList() {
        tramitantesList = controller.getTramitantesList();
        return tramitantesList;
    }

    public void setTramitantesList(List tramitantesList) {
        this.tramitantesList = tramitantesList;
    }
    
    public Tramitantes getTramitantes() {
        return tramitantes;
    }

    public void setTramitantes(Tramitantes tramitantes) {
        this.tramitantes = tramitantes;
    }

    
    public void nuevoTramitante()
    {
        tramitantes = new Tramitantes();
       
    }

    
}
