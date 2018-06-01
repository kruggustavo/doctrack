/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.DocumentosController;
import entities.institucion.Superviciones;
import entities.seguimiento.Documentos;
import entities.seguimiento.Seguimiento;
import entities.seguimiento.Tramitantes;
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
public class DocumentosBean implements Serializable {

    private static final long serialVersionUID = -4122271392021898485L;

    private String numeroDoc;
    private String descripcion;
    private String fechaentrada;
    private String observacion;
    //para las claves foraneas
    private String tramitantes;
    private String superviciones;


    //el siguiente List es para la lista de Documentos
    private List<Documentos> listaDoc;
    //creo una lista de superviciones y tramitantes que van servir como fk
    private List<Superviciones> listaSup;
    private List<Tramitantes> listaTram;

    //creo variable de tipo documento y seguimiento
    private Documentos documentos;
    private Seguimiento seguimiento;
    //instancio el controlador
    private DocumentosController controller = new DocumentosController();

    //metodo que crea un objeto, por lo momento vacio
    public void nuevoDocumento()
    {
        documentos = new Documentos();
        seguimiento = new Seguimiento();
        //aquie estos dos objetos y como las variables estan vacias por eso no pongo lo siguiente porque estara vacio numeroDoc = documentos.getNumeroDoc();
    }

    public void editarDocumento()
    {
       tramitantes = documentos.getIdTramitante().getCi(); //aqui solo tengo el idFk por eso consulto para que me traiga el objeto en si
       superviciones = documentos.getIdSupervicion().getNumeroSupervision();
    }
    
    public void anularDocumento()
    {
        boolean mensResp = true;
        //en esta caso no hago nada con Documento, dejo asi como esta
        //documento tiene un objeto seleccionado pero seguimiento no se selecciona, entonces consuulto por objeto seguimiento con el Fk que esta en documentos
        if (documentos.getId() != null && seguimiento == null){
            System.out.println("el id del docuemento en anular "+documentos.getId());
            seguimiento = controller.getSeguimientoEntity(documentos.getId());
            seguimiento.setEstadogeneral("Anulado");
            controller.saveSeguimiento(seguimiento);
            seguimiento = null;
        }else{
            mensResp= false;
        } 
        if(mensResp == true)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Anulación de Documento con exito"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
    }
    
    //metodo para actulizar lo editado del documento
    public void actualizarDocumento()
    {
        //solo verifico que el tramitante y la supervicion fueron seleccionados       
        boolean mensResp = true;
        if(tramitantes != null && superviciones != null && seguimiento == null) //no crep objeto solo el seleccionado
        {
            Tramitantes tr = null;
            Superviciones sp = null;
            tr = controller.getTramitanteEntity(tramitantes);
            sp = controller.getSupervicionEntity(superviciones);
            documentos.setIdTramitante(tr);
            documentos.setIdSupervicion(sp);
            controller.saveDocumentos(documentos); //la fecha no se cargara en esta parte, quedara con la que esta
            //luego de guardar el documento le creo un primer seguimiento con estado de recibido
            //el objeto seguimiento creo porque no se selecciona en la interfaz, solo el documento
            if (documentos.getId() != null)
            {
                System.out.println("id del documento en actualizar "+documentos.getId());
                seguimiento = controller.getSeguimientoEntity(documentos.getId());
                seguimiento.setDescripcion(documentos.getDescripcion()); //la misma descripcion que el del documento
                controller.saveSeguimiento(seguimiento);
                seguimiento = null;
            }
            else
            {
                mensResp = false;
            }
            documentos = null;
        }
        else 
        {
            mensResp = false;
        }
        if(mensResp == true)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Actualización de Registro con exito"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
    }
    
    //metodo para guardar
    public void guardarDocumento()
    {
        //antes que nada verifico que el numero de documento no se encuentre repetido
        int resultadoEnc = controller.getNumdocList(documentos.getNumeroDoc()).size();
        System.out.println("tamaño lista "+resultadoEnc);
        if(resultadoEnc <= 0)
        {
            //Buscamos el tramitante apartir de la c.i seleccionada, en el caso de no ser seleccionado busca de la lista y agrega el primer valor de la lista
            Tramitantes tr = null;
            if (tramitantes == null){
                tr = (Tramitantes) controller.getTramitantesList().get(0);
                tramitantes = tr.getCi();
            }else{
                tr = controller.getTramitanteEntity(tramitantes);
            }
            //buscamos la supervision apartir del numero de supervision
            Superviciones sp = null;
            if (superviciones == null){
                sp = (Superviciones) controller.getSupervicionList().get(0);
                superviciones = sp.getNumeroSupervision();
            }else{
                sp = controller.getSupervicionEntity(superviciones);
            }
            //tambien obtengo la fecha y hora actual
            Date date = new Date();
            //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd"); //dejo en esta forma porque es la acepta mysql
            //String fechaHoraActual = hourdateFormat.format(date);
            //agrego los datos faltantes que son las foraneas
            documentos.setIdTramitante(tr);
            documentos.setIdSupervicion(sp);
            documentos.setFechaentrada(date);

            controller.saveDocumentos(documentos);
            //luego de guardar el documento le creo un primer seguimiento con estado de recibido
            boolean mensResp = true;
            if (documentos.getNumeroDoc() != null)
            {
                System.out.println("el documento no es nulo, tiene el valor "+documentos.getNumeroDoc());
                seguimiento.setFechaentrada(date); //fecha entrada es el mismo que el del documento y fecha de salida queda inicalmente en null
                seguimiento.setFechasalido(date);
                seguimiento.setDescripcion(documentos.getDescripcion()); //la misma descripcion que el del documento
                seguimiento.setEstadogeneral("Recibido");
                seguimiento.setIdDocumento(documentos);
                controller.saveSeguimiento(seguimiento);
                seguimiento = null;
            }
            else
            {
                mensResp = false;
            }
            documentos = null;
            //mensaje de modificaciones
            if(mensResp == true)
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro de Documento con exito"));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
            }//SEVERITY_WARN
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Número de Documento especificado ya existe, intente con otro número"));
        }
    }
    
    //metodo para listar los Documentos
    public List<Documentos> getListaDoc() {
        listaDoc = controller.getDocumentosList();
        return listaDoc;
    }

    public void setListaDoc(List<Documentos> listaDoc) {
        this.listaDoc = listaDoc;
    }

    public Documentos getDocumentos() {
        return documentos;
    }

    public void setDocumentos(Documentos documentos) {
        this.documentos = documentos;
    }

    public String getTramitantes() {
        return tramitantes;
    }

    public void setTramitantes(String tramitantes) {
        this.tramitantes = tramitantes;
    }
    
    public String getSuperviciones() {
        return superviciones;
    }

    public void setSuperviciones(String superviciones) {
        this.superviciones = superviciones;
    }
    
    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public List<Superviciones> getListaSup() {
        listaSup = controller.getSupervicionList();
        return listaSup;
    }

    public void setListaSup(List<Superviciones> listaSup) {
        this.listaSup = listaSup;
    }

    public List<Tramitantes> getListaTram() {
        listaTram = controller.getTramitantesList();
        return listaTram;
    }

    public void setListaTram(List<Tramitantes> listaTram) {
        this.listaTram = listaTram;
    }
    
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
}
