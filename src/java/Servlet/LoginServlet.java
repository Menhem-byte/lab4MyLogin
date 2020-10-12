package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 789438
 */
public class LoginServlet extends HttpServlet {

  
   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session= request.getSession();
        if(request.getParameter("logout") !=null){
        session.invalidate();
        request.setAttribute("message","User Logged Out Successfully!");
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        else if (session.getAttribute("username")!=null){
        response.sendRedirect(request.getContextPath() +"/home");
        }
        else {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         User user =null;
        
    
       String username= request.getParameter("username");
       String password=(String) request.getParameter("password");
       
       if(username==null || username.equals("") || password.equals("") || password==null){
       request.setAttribute("user", username);
       request.setAttribute("pass",password);
       request.setAttribute("message","please enter  username and password");
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           
       }
       else{
       AccountService as=new AccountService();
         user =as.login(username, password);
       }
       
       if(user ==null){
       request.setAttribute("user", username);
       request.setAttribute("pass",password);
       request.setAttribute("message","user not found.");
       getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
       
       else{
       HttpSession session=request.getSession();
       session.setAttribute("username", username);
       response.sendRedirect(request.getContextPath() +"/home");
       }
       
 
    }

  

}
