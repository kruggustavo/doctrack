/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.GestionDocController;
import entities.institucion.Areas;
import entities.seguimiento.Gestiondocumentos;
import entities.seguimiento.Seguimiento;
import java.io.Serializable;
import java.util.Date;
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
public class GestionDocBean implements Serializable {

    private static final long serialVersionUID = -7544131015556585607L;

    private String fechaEntrada;
    private String fechaSalida;
    private String estadogeneral;
    private String descripcion;
    //variable tipo seguimiento
    private Seguimiento seguimiento;
    //para foranea de Areas, que con ella utilizare para encontrar el objeto distrito
    private String areas;
    //lista de resultados
    private List<Seguimiento> listaSeguimiento;
    //lista de areas
    private List<Areas> listaAreas;

    //objeto para obtener la ultima gestion del documento seleccionado
     //variable de la tabla gestiondocumentos
    private String asuntoGest;
    private String obsGest;
    
    //instancio el controlador
    GestionDocController controller = new GestionDocController();
    

    public void procesarDocumento() //con este metodo logro cambiar el estado de seguimiento y insertar una una gesiondocumento
    {
        if(seguimiento != null)
        {
            //consulto si ya no esta procesado, ya que solo una vez se puede procesar
            if(seguimiento.getEstadogeneral().equals("Procesado"))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Documento especificado ya se encuentra Procesado, solo es posible procesar una vez"));
            }
            else
            {
                if(areas != null && asuntoGest != null && obsGest != null)
                {
                    seguimiento.setEstadogeneral("Procesado"); //solo hago esta modificacion a seguimiento
                    controller.saveSeguimiento(seguimiento);
                    Gestiondocumentos gdoc = new Gestiondocumentos();
                    Areas ar = new Areas();
                    ar = controller.getAreaEntity(areas);
                    gdoc.setAsunto(asuntoGest);
                    gdoc.setEstadogestion("Procesado"); //este no es necesario ya que ya hay un estado general en seguimiento
                    gdoc.setFecha(new Date());
                    gdoc.setIdArea(ar);
                    gdoc.setObservacion(obsGest);
                    gdoc.setIdSeguimiento(seguimiento);
                    gdoc.setIdDependencia(ar.getIdDependencia());
                    controller.saveGestiondocumentos(gdoc);
                    seguimiento = null;
                    ar = null;
                    gdoc = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Documento Procesado con éxito"));
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
    }
    
    public void moverDocumento() //con este metodo logro cambiar el estado de seguimiento y insertar una una gesiondocumento
    {
        if(seguimiento != null && areas != null)
        {
            //consulto si ya no esta procesado, ya que solo una vez se puede procesar
            if(!seguimiento.getEstadogeneral().equals("Procesado"))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Documento especificado debe ser primeramente Procesado para poder luego ser movido a un nuevo Sector de Dependencias"));
            }
            else
            {
                Gestiondocumentos ultimaGestion = (Gestiondocumentos) controller.getUltimaGestionList(seguimiento.getId()).get(0);
                if(ultimaGestion.getIdArea().getNombre().equals(areas))
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Documento especificado ya se encuentra en el Sector de Dependencia seleccionado"));
                }
                else
                {
                    if(areas != null && asuntoGest != null && obsGest != null)
                    {
                        //en esta seccion no necesito cambiar el estado, ya que siempre se mantendran en procesado hasta llegar a concluirse
                        Gestiondocumentos gdoc = new Gestiondocumentos();
                        Areas ar = new Areas();
                        ar = controller.getAreaEntity(areas);
                        gdoc.setAsunto(asuntoGest);
                        gdoc.setFecha(new Date());
                        gdoc.setIdArea(ar);
                        gdoc.setEstadogestion("Procesado");
                        gdoc.setObservacion(obsGest);
                        gdoc.setIdSeguimiento(seguimiento);
                        gdoc.setIdDependencia(ar.getIdDependencia());
                        controller.saveGestiondocumentos(gdoc);
                        seguimiento = null;
                        ar = null;
                        gdoc = null;
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "El Documento se ha movido a un nuevo Sector de Dependencia con éxito"));
                    }
                    else
                    {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
                    }
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
    }
    
        
    public void concluirDocumento() 
    {
        if(seguimiento != null)
        {
            //consulto si ya no esta procesado, ya que solo una vez se puede procesar
            if(!seguimiento.getEstadogeneral().equals("Procesado"))
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Documento especificado debe ser primeramente Procesado para poder luego ser concluido"));
            }
            else
            {
                Gestiondocumentos ultimaGestion = (Gestiondocumentos) controller.getUltimaGestionList(seguimiento.getId()).get(0);
                if(ultimaGestion != null && areas != null)
                {
                    //doy por conculuido el seguimiento actualizando el estado
                    seguimiento.setEstadogeneral("Concluido");
                    seguimiento.setFechasalido(new Date());
                    controller.saveSeguimiento(seguimiento);
                    //la ultima gestion supone ser de la coordinacion, a la cual se le cambia el estado a concluido en esta parte ya no se inserta
                    ultimaGestion.setEstadogestion("Concluido");
                    controller.saveGestiondocumentos(ultimaGestion);

                    seguimiento = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Seguimiento de Documento Concluido con éxito"));
                }
                else
                {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
                }
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
    }
    
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

    public List<Seguimiento> getListaSeguimiento() {
        listaSeguimiento = controller.getSeguimientoList();
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }
    
    public List<Areas> getListaAreas() {
        listaAreas = controller.getAreasList();
        return listaAreas;
    }

    public void setListaAreas(List<Areas> listaAreas) {
        this.listaAreas = listaAreas;
    }
    
    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }
    
    public String getAsuntoGest() {
        return asuntoGest;
    }

    public void setAsuntoGest(String asuntoGest) {
        this.asuntoGest = asuntoGest;
    }

    public String getObsGest() {
        return obsGest;
    }

    public void setObsGest(String obsGest) {
        this.obsGest = obsGest;
    }
    
}
