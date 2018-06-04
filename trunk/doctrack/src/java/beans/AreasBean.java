/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.AreasController;
import entities.institucion.Areas;
import entities.institucion.Dependencias;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Lucas Fleitas
 */

@ManagedBean
@SessionScoped
public class AreasBean implements Serializable {

    private static final long serialVersionUID = -7000446832637072077L;

    private String nombre;
    private List<Areas> areasList;
    private List<Dependencias> dependenciasList;
    //variable para FK
    private String dependencias;
    //objeto areas
    private Areas areas;
    //instalcia del controlador
    private AreasController controller = new AreasController();

    public void nuevaAreas()
    {
        areas = new Areas();
    }
    
    public void editarAreas()
    {
        dependencias = areas.getIdDependencia().getNombre();
    }
    
    public void guardarAreas()
    {
        int resultadoEnc = controller.getNombreAreaList(areas.getNombre()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            //Buscamos Distrito a partir de la descripcion elegida en pantalla
            Dependencias d = null;
            if (dependencias == null){
                d = (Dependencias) controller.getDependenciasList().get(0);
                dependencias = d.getNombre();
            }else{
                d = controller.getDependenciaEntity(dependencias);
            }
            areas.setIdDependencia(d);
            controller.saveAreas(areas);
            areas = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Sector de Dependencia creada con éxito"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Sector de la Dependencia especificada ya existe"));
        }
    }
    
    public void actualizarAreas()
    {
        System.out.println("los valores son "+areas.getNombre()+" "+ areas.getId());
        int resultadoEnc = controller.getActareaList(areas.getNombre(), areas.getId()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            if(dependencias != null)
            {
                Dependencias d = null;
                d = controller.getDependenciaEntity(dependencias);
                areas.setIdDependencia(d);
                controller.saveAreas(areas);
                areas = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Actualización Sector de Dependencia con éxito"));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Sector de la Dependencia especificada ya existe"));
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Areas> getAreasList() {
        areasList = controller.getAreasList();
        return areasList;
    }

    public void setAreasList(List areasList) {
        this.areasList = areasList;
    }

    public List<Dependencias> getDependenciasList() {
        dependenciasList = controller.getDependenciasList();
        return dependenciasList;
    }

    public void setDependenciasList(List dependenciasList) {
        this.dependenciasList = dependenciasList;
    }

    public String getDependencias() {
        return dependencias;
    }

    public void setDependencias(String dependencias) {
        this.dependencias = dependencias;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }
    
    
}
