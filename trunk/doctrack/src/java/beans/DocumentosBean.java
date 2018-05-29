/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.DocumentosController;
import entities.institucion.Superviciones;
import entities.seguimiento.Documentos;
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
public class DocumentosBean implements Serializable {

    private static final long serialVersionUID = -4122271392021898485L;

    private String numeroDoc;
    private String descripcion;
    private String fechaentrada;
    private String observacion;
    //para las claves foraneas
    private String superviciones;
    private String tramitantes;
    //el siguiente List es para la lista de Documentos
    private List<Documentos> listaDoc;
    //creo un objeto documento
    private Documentos documentos;
    //instancio el controlador
    private DocumentosController controller = new DocumentosController();

    //metodo que crea un objeto, por lo momento vacio
    public void nuevoDocumento()
    {
        documentos = new Documentos();
    }
    
    //metodo para guardar/actualizar el documento
    public void guardarDocumento()
    {
        //Buscamos el tramitante apartir de la c.i seleccionada
        Tramitantes tr = null;
        if (tramitantes == null){
            tr = (Tramitantes) controller.getTramitantesList().get(0);
            tramitantes = tr.getCi();
        }else{
            tr = controller.getTramitanteEntity(tramitantes);
        }
        //Buscamos la supervicion apartir del nombre de la supervicion seleccionada
        Superviciones sp = null;
        if (superviciones == null){
            sp = (Superviciones) controller.getSupervicionList().get(0);
            superviciones = sp.getNumeroSupervision();
        }else{
            tr = controller.getTramitanteEntity(superviciones);
        }
        //agrego los datos faltantes que son las foraneas
        documentos.setIdTramitante(tr);
        documentos.setIdSupervicion(sp);
        controller.saveDocumentos(documentos);
        documentos = null;
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
    
    public String getSuperviciones() {
        return superviciones;
    }

    public void setSuperviciones(String superviciones) {
        this.superviciones = superviciones;
    }

    public String getTramitantes() {
        return tramitantes;
    }

    public void setTramitantes(String tramitantes) {
        this.tramitantes = tramitantes;
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

}
