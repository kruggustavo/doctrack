/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.TipoDocController;
import entities.seguimiento.Tipodocumento;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucas Fleitas
 */
@ManagedBean
@ViewScoped
public class TipoDocBeans implements Serializable {
    private static final long serialVersionUID = 7408554760804220976L;

    private String nombre;
    private List tipDocList;
    private Tipodocumento tipodocumento;
    private final TipoDocController controller = new TipoDocController();

    public void nuevoTipodocumento()
    {
        tipodocumento = new Tipodocumento();
    }
    
    public void guardarTipodocumento()
    {
        int resultadoEnc = controller.getTipodocNombreList(tipodocumento.getNombre()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            controller.SaveTipoDoc(tipodocumento);
            tipodocumento = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tipo de Documento Creado con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe el Tipo de Documento especificado ya existe"));
        }
    }
    
    public void actualizarTipodocumento()
    {
        int resultadoEnc = controller.getTipodocActList(tipodocumento.getNombre(), tipodocumento.getId()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            controller.SaveTipoDoc(tipodocumento);
            tipodocumento = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tipo de Documento Actualizado con éxito!"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "Ya existe el Tipo de Documento especificado ya existe"));
        }
    }
    

    public Tipodocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(Tipodocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List getTipDocList() {
        tipDocList = controller.getTipoDocList();
        return tipDocList;
    }

    public void setTipDocList(List tipDocList) {
        this.tipDocList = tipDocList;
    }
    
}
