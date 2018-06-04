/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controllers.UserController;
import entities.users.Usuarios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import util.Authorization;
import util.HibernateUtil;
import util.LoggerUtil;
import util.SessionUtil;
/**
 *
 * @author Lucas Fleitas
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
    private static final long serialVersionUID = -411392021898485L;
    public static boolean isLogged = false;
    
    private UserController controller = new UserController();
    
    private boolean isLogin = false;
    private Usuarios currentUser = null;
    private String user = "";
    private String pwd = "";

    public String getInit(){
        HibernateUtil.getSessionFactory();
        return null;
    }
    
    public void loginListener(){
        isLogin = true;
    }
    
    public String login() {
        if (user.length() > 0){
            Usuarios u = controller.getLoginUser(user, pwd);
            user = pwd = "";            
            isLogin = false;
                
            if (u != null) {
                LoginBean.isLogged = true;

                LoggerUtil.setMDCParams("userId", u.getId());
                LoggerUtil.logInfo("Inicio de sesion");
                
                currentUser = u;
                Authorization.currentUser = u; 

                HttpSession session = SessionUtil.getSession();
                session.setAttribute(Authorization.USERNAME, user);

                return Authorization.HOME_URL;
            } else {
                LoginBean.isLogged = false;

                currentUser = null;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",  "Usuario y/o contraseña incorrecta") );
                return Authorization.LOGIN_PAGE;
            }            
        }
        return null;
    }
    
    //logout event, invalidate session
    public String logout() {
        LoginBean.isLogged = false;
        HttpSession session = SessionUtil.getSession();
        session.removeAttribute(Authorization.USERNAME);
        session.invalidate();
        
        return Authorization.LOGIN_URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Usuarios getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuarios currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
    
}
