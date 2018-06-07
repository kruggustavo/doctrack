/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.RespuestaController;
import controllers.SupervisionController;
import entities.seguimiento.Respuesta;
import entities.seguimiento.Seguimiento;
import entities.seguimiento.Tipodocumento;
import entities.users.Funcionarios;
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
public class RespuestasBean implements Serializable {

    private static final long serialVersionUID = -4893910865156308869L;

    private String numero;
    private String dirigidoa;
    private String asunto;
    private String redaccion;
    //objeto seguimieto
    private Seguimiento seguimiento;

    private List<Funcionarios> listFuncionarios;
    private List<Tipodocumento> listTipodocumento;
    private List<Seguimiento> listSeguimiento;
    //variable para consultar FK
    private String selectFuncionario;
    private String selectTipodocumento;

   private RespuestaController controller = new RespuestaController();

    
    public void guardarRespuesta()
    {
        System.out.println("el valor id seg "+seguimiento.getId()+"numero "+numero+" dirigido "+dirigidoa+" asunto "+asunto+" redaccion "+redaccion+" funcionario ci "+selectFuncionario+" tipodoc id "+selectTipodocumento);
        if(seguimiento.getId() != null && numero != null && dirigidoa != null && asunto != null && redaccion!= null && selectFuncionario != null && selectTipodocumento != null)
        {
            //verifico que el numero de documento con el mismo tipo de documento ya no exista
            int resultadoEnc = controller.getNumRespuestaList(numero, selectTipodocumento).size();
            System.out.println("tamaño lista "+resultadoEnc);
            if(resultadoEnc <= 0)
            {
                Funcionarios f = null;
                f = controller.getFuncionariooEntity(selectFuncionario);
                Tipodocumento td = null;
                td = controller.getTipodocumentoEntity(selectTipodocumento);
                //cambio a respondido si en seguimiento
                seguimiento.setNuevoCampo("Si");
                controller.saveSeguimiento(seguimiento);
                //traigo ese objeto guardado
                Date date = new Date();
                Respuesta respuesta = new Respuesta();
                respuesta.setFecha(date);
                respuesta.setNumero(numero);
                respuesta.setDirigidoa(dirigidoa);
                respuesta.setAsunto(asunto);
                respuesta.setRedaccion(redaccion);
                respuesta.setIdTipodoc(td);
                respuesta.setIdFuncionario(f);
                respuesta.setIdSeguimiento(seguimiento);
                //ya esta funcionando terminar de ordenar el codigo, el problema era que no se tenia el autoincremento
                controller.saveRespuesta(respuesta);
                respuesta = null;
                seguimiento = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Respuesta de Documentos Conluidos, concluido con éxito"));
            }
            else
            {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención!", "El Número de Respuesta especificada ya existe, intente con otro número"));
            }
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ha ocurrido un error pongase en contacto con su proveedor"));
        }
        
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDirigidoa() {
        return dirigidoa;
    }

    public void setDirigidoa(String dirigidoa) {
        this.dirigidoa = dirigidoa;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getRedaccion() {
        return redaccion;
    }

    public void setRedaccion(String redaccion) {
        this.redaccion = redaccion;
    }

    public List<Funcionarios> getListFuncionarios() {
        listFuncionarios = controller.getListFuncionarios();
        return listFuncionarios;
    }

    public void setListFuncionarios(List<Funcionarios> listFuncionarios) {
        this.listFuncionarios = listFuncionarios;
    }

    public List<Tipodocumento> getListTipodocumento() {
        listTipodocumento = controller.getListTipodocumento();
        return listTipodocumento;
    }

    public void setListTipodocumento(List<Tipodocumento> listTipodocumento) {
        this.listTipodocumento = listTipodocumento;
    }

    public List<Seguimiento> getListSeguimiento() {
        listSeguimiento = controller.getSeguientoNoRespList();
        return listSeguimiento;
    }

    public void setListSeguimiento(List<Seguimiento> ListSeguimiento) {
        this.listSeguimiento = ListSeguimiento;
    }

    public String getSelectFuncionario() {
        return selectFuncionario;
    }

    public void setSelectFuncionario(String selectFuncionario) {
        this.selectFuncionario = selectFuncionario;
    }

    public String getSelectTipodocumento() {
        return selectTipodocumento;
    }

    public void setSelectTipodocumento(String selectTipodocumento) {
        this.selectTipodocumento = selectTipodocumento;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }
    
}
