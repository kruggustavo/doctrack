/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import beans.LoginBean;
import java.io.IOException; 
import javax.faces.application.ResourceHandler;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

public class Authorization implements Filter{
    public static final String LOGIN_PAGE = "/login.xhtml";
    public static final String LOGIN_URL = "/login.xhtml?faces-redirect=true";
    public static final String HOME_URL = "/secured/home.xhtml?faces-redirect=true";
    public static final String USERNAME = "username";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        // managed bean name is exactly the session attribute name
        HttpSession session = httpServletRequest.getSession();
        String username = (String) session.getAttribute(USERNAME);

        if (httpServletRequest.getRequestURL().toString().contains("/secured/")) {
            if (session == null || username == null) {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
            }
        }
        
        if (LoginBean.isLogged == true) {
            // user is logged in, continue request
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // user is not logged in, redirect to login page
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + LOGIN_PAGE);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void destroy() {
      // close resources
    }
}