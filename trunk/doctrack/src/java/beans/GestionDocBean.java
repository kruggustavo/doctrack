/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.GestionDocController;
import entities.seguimiento.Documentos;
import entities.seguimiento.Seguimiento;
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
public class GestionDocBean implements Serializable {

    private static final long serialVersionUID = -7544131015556585607L;

    private String fechaEntrada;
    private String fechaSalida;
    private String estadogeneral;
    private String descripcion;
    //variable tipo seguimiento
    private Seguimiento seguimiento;
    //claves foraneas
    private String documentos;
    //lista de resultados
    private List<Seguimiento> listaSeguimiento;
    //lista de resultados de la FK
    private List<Documentos> listaDocumentos;
    //instancio el controlador
    GestionDocController controller = new GestionDocController();

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstadogeneral() {
        return estadogeneral;
    }

    public void setEstadogeneral(String estadogeneral) {
        this.estadogeneral = estadogeneral;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }

    public List<Seguimiento> getListaSeguimiento() {
        listaSeguimiento = controller.getGestiondocumentosList();
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }

    public List<Documentos> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<Documentos> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }
    
    
    
    
    
}
