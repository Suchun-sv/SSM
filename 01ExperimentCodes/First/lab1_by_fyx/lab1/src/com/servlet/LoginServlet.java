package com.servlet;

import com.domain.User;
import com.service.UserServiceImp;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        User user=new User();

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String remember=request.getParameter("remember");


        user.setUsername(username);
        user.setPassword(password);

        ServletContext context = getServletContext();//ServletContext对象的作用是在整个Web应用的动态资源之间共享数据
        ApplicationContext app = (ApplicationContext) context.getAttribute("ApplicationContext");
        UserServiceImp usip=app.getBean("usip",UserServiceImp.class);

        User usercheck=usip.loginUser(user);//usercheck不为empty则找到张三

        String gcp = request.getContextPath();

        if ("true".equals(remember)&&usercheck!=null){
            Cookie cookie1 =new Cookie("remember",remember);
            cookie1.setMaxAge(60*60);

            Cookie cookie2 =new Cookie("username",username);
            cookie2.setMaxAge(60*60);

            Cookie cookie3 =new Cookie("password",password);
            cookie3.setMaxAge(60*60);

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);
        }
        else {
            Cookie[] cks = request.getCookies();
            if (cks != null) {
                for (Cookie c : cks) {
                    c.setMaxAge(0); //清除
                    response.addCookie(c);
                }
            }
        }


        if (usercheck != null) {

            response.sendRedirect(gcp + "/success.jsp");
        } else {
            response.sendRedirect(gcp + "/error.jsp");
        }




    }


    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        System.out.println("服务器被访问了");
//        //使用spring创建对象，并调用对象的方法
//        ServletContext context = getServletContext();
//        ApplicationContext app = (ApplicationContext) context.getAttribute("ApplicationContext");
//        User user= app.getBean("userService", User.class);
//        System.out.println(user);

            doPost(request,response);
    }

}

