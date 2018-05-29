/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.ResolutionController;
import entities.users.Funcionarios;
import entities.resolution.Resolucion;
import java.io.Serializable;
import java.util.List;;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class ResolutionBean implements Serializable{
    private static final long serialVersionUID = -6680733133634363295L;
    
    private String fecha;
    private String numero;
    private String resuelve;
    private String visto;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getResuelve() {
        return resuelve;
    }

    public void setResuelve(String resuelve) {
        this.resuelve = resuelve;
    }

    public String getVisto() {
        return visto;
    }

    public void setVisto(String visto) {
        this.visto = visto;
    }

    public List getFuncionariosList() {
        return funcionariosList;
    }

    public void setFuncionariosList(List funcionariosList) {
        this.funcionariosList = funcionariosList;
    }

    public String getSelectedFuncionarios() {
        return selectedFuncionarios;
    }

    public void setSelectedFuncionarios(String selectedFuncionarios) {
        this.selectedFuncionarios = selectedFuncionarios;
    }

    
    private List resolutionList;
    private List funcionariosList;
    
    private Resolucion selectedResolution;
    private String selectedFuncionarios;
    
    private final ResolutionController controller = new ResolutionController();
    
     //Métodos usados como actionListeners del CRUD de Resolucion & Funcionario
    public void nuevaResolucion(){
        selectedResolution = new Resolucion();
    }
    
    public void guardarResolucion(){          
        //Buscamos Funcionario a partir del nombre elegida en pantalla
        Funcionarios f = null;
        if (selectedFuncionarios == null){
            f = (Funcionarios) controller.getFuncionariosList().get(0);
            selectedFuncionarios = f.getNombreCompleto();
        }else{
            f = controller.getFuncionariosEntity(selectedFuncionarios);
        }
        selectedResolution.setIdFuncionario(f);
        
        controller.saveResolution(selectedResolution);
        selectedResolution = null;
    }
    
    public void eliminarResolucion(){
        controller.deleteResolution(selectedResolution);
        selectedResolution = null;
    }
    
    // Getters y Setters
    public List getResolutionList() {
        resolutionList = controller.getResolutionList();
        return resolutionList;
    }

    public void setResolutionList(List usersList) {
        this.resolutionList = usersList;
    }

    public Resolucion getSelectedResolution() {
        return selectedResolution;
    }

    public void setSelectedResolution(Resolucion selectedResolution) {
        this.selectedResolution = selectedResolution;
    }
    
    
}
