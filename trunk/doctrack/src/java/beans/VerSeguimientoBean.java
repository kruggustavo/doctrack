/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.GestionDocController;
import entities.seguimiento.Gestiondocumentos;
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
public class VerSeguimientoBean implements Serializable {

    private static final long serialVersionUID = -4085298340576118821L;

    private Seguimiento seguimiento;
    private List<Seguimiento> listaSeguimiento;
    //de la ultima area
   Gestiondocumentos gestionDocumentos;


    GestionDocController controller = new GestionDocController();

    public void ultimoSeguimiento()
    {
        if(seguimiento != null)
        {
            int d = controller.getUltimaGestionList(seguimiento.getId()).size();
            if(d > 0)
            {
                System.out.println("el seguimiento es distinto de nulo y la lista de ultimo no es nulo");
                Gestiondocumentos ultimaGestion = (Gestiondocumentos) controller.getUltimaGestionList(seguimiento.getId()).get(0);
                gestionDocumentos = ultimaGestion;
            }
            else
            {
                gestionDocumentos = null;
            }
        }
    }
    
    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
        System.out.println("setea ahora");
        ultimoSeguimiento();
    }

    public List<Seguimiento> getListaSeguimiento() {
        listaSeguimiento = controller.getListaSeguimientos();
        return listaSeguimiento;
    }

    public void setListaSeguimiento(List<Seguimiento> listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }

    public Gestiondocumentos getGestionDocumentos() {
        return gestionDocumentos;
    }

    public void setGestionDocumentos(Gestiondocumentos gestionDocumentos) {
        this.gestionDocumentos = gestionDocumentos;
    }
    
}
