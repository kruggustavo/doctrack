package beans;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import controllers.UserController;
import entities.users.Funcionarios;
import java.io.Serializable;
import java.util.List;import javax.faces.application.FacesMessage;
;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author usuario
 */

@ManagedBean
@SessionScoped
public class EmployeesBean implements Serializable{
    private static final long serialVersionUID = -6880733133634363257L;
    
    private Funcionarios selectedEmployee;
    private List employeesList;
    
    private UserController controller = new UserController();

    //Métodos usados como actionListeners del CRUD de Funcionarios & Roles
    public void nuevoFuncionario(){
        selectedEmployee = new Funcionarios();
        selectedEmployee.setNombreCompleto("");
    }
    
    public void guardarFuncionario(){          
        controller.saveEmployee(selectedEmployee);
        selectedEmployee = null;
    }
    
    public void eliminarFuncionario(){   
        String idFuncionario = selectedEmployee.getId().toString();
        try{
            String query = "UPDATE resolucion SET idFuncionario = '' WHERE idFuncionario = '" + idFuncionario + "'";

            controller.executeSqlQuery(query);
            controller.deleteEmployee(selectedEmployee);
            
            selectedEmployee = null;
        }catch (Exception m){ 
            System.out.println("Errpor");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aviso", "No se puede eliminar funcionario asociado actualmente a tramite")); 
        }
    }

    public List getEmployeesList() {
        this.employeesList = controller.getEmployeesList();
        return this.employeesList;
    }

    public void setEmployeesList(List employeesList) {
        this.employeesList = employeesList;
    }

    public Funcionarios getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Funcionarios selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }
    
   
    
}
