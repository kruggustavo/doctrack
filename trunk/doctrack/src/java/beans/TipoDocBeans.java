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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
        controller.SaveTipoDoc(tipodocumento);
        tipodocumento = null;
    }
    
    public void eliminarTipodocumento(){
        controller.deleteTipoDoc(tipodocumento);
        tipodocumento = null;
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
