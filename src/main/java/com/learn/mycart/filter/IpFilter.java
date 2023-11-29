package com.learn.mycart.filter;

import com.learn.mycart.dao.ConnectionDao;
import com.learn.mycart.entities.UserConnection;
import com.learn.mycart.helper.FactoryProvider;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;


public class IpFilter implements Filter {
     // inite filter
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        
          // Convert ServletRequest object to HttpServletRequest object
         HttpServletRequest httpRequest = (HttpServletRequest) request;
         
         // Convert ServletResponse object to HttpServletResponse object
        HttpServletResponse httpResponse = (HttpServletResponse) response;
         
        // Get the user's IP address from the request
        String userIpAddress = request.getRemoteAddr();

        // store Ip address in session
        HttpSession session = httpRequest.getSession();
        Object userIpAdress=session.getAttribute("userIpAddress");
        
        if (userIpAdress==null){
            //First user connection to store in attribute
            LocalDateTime CoDateTime=LocalDateTime.now();
            UserConnection uconnection = new UserConnection();
            uconnection.setuAdressIp(userIpAddress);
            uconnection.setCoDateTime(CoDateTime);

            //user connection databse save:
            ConnectionDao connectionDao = new ConnectionDao(FactoryProvider.getFactory());
            int CoId = connectionDao.saveConnection(uconnection);
            
            //out.println("Connection Saved");
            HttpSession httpSession = httpRequest.getSession();
            httpSession.setAttribute("userIpAddress", "Connection ajoutée avec succès : " + CoId);
            httpResponse.sendRedirect("index.jsp");   
        }
        
        // allows you to continue the filter chain or take the request to the servlet indicated in the request url
        chain.doFilter(request, response);
        

    }
    @Override
    public void destroy() {
        // Destruction of the filter (not use..)
    }
}