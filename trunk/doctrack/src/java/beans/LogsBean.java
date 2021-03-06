/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.LogsController;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author usuario
 */

@ManagedBean
@SessionScoped
public class LogsBean implements Serializable{
    private List logsList;
    private List filteredLogs;
    private LogsController controller = new LogsController();
    
    public List getLogsList() throws ParseException {
        logsList = controller.getLogs();
        return logsList;
    }

    public void setLogsList(List getLogsList) {
        this.logsList = getLogsList;
    }

    public List getFilteredLogs() {
        return filteredLogs;
    }

    public void setFilteredLogs(List filteredLogs) {
        this.filteredLogs = filteredLogs;
    }
    
    
}
