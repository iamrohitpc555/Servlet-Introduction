package org.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (
        description = "Login Servlet Testing",
        urlPatterns ={ "/LoginServlet" },
        initParams = {
            @WebInitParam(name = "user", value = "Rohit"),
            @WebInitParam(name = "password", value = "Capita")
        }
)
public class LoginServlet extends HttpServlet {
    @Override
   
    protected void doPost(HttpServletRequest req, HttpServletResponse rec) throws ServletException, IOException{
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        //String userId  = getServletConfig().getInitParameter("user");
        //String password = getServletConfig().getInitParameter("password");
        if(user.matches("^[A-Z][A-Za-z]{2,}$") && pwd.matches("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?!.*[<>`])" + "(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)" + ".{8,}$")){
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req,rec);
        }else{
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = rec.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            requestDispatcher.include(req,rec);
        }
    }

}