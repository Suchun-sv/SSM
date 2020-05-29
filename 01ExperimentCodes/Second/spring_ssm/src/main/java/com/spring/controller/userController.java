package com.spring.controller;

import com.spring.domain.User;
import org.apache.ibatis.annotations.ResultMap;
//import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.spring.service.userService;
import com.spring.service.friendService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
@SessionAttributes("userID")
public class userController {

    @Autowired
    private userService user_service;

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    private HttpServletResponse response;

    @RequestMapping(value = "/login")
    @CrossOrigin(origins = "*",maxAge = 3600)
    @ResponseBody
    public void login(String username, String password, String is_remembered, Model model, HttpServletRequest req, HttpServletResponse rep) throws IOException {
        System.out.println("===================================================");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        rep.setCharacterEncoding("UTF-8");
        //2.直接规定浏览器看这份数据的时候，使用什么编码来看。
        rep.setHeader("Content-Type", "text/html; charset=UTF-8");
        System.out.println("输入为:"+user.getUsername()+" "+user.getPassword());
        if(is_remembered.equals("0"))
        {
            System.out.println("没有默认保存密码！");
            try {
                user_service.verify(user);
                model.addAttribute("userID", user_service.findUserID(user));
                rep.getWriter().write("./friend/redirect");
//                rep.sendRedirect("../friend/redirect");
            }
            catch (Exception e)
            {
                String[] ewarnings = e.toString().split(":");
                String ewarning = ewarnings[1];
                System.out.println(ewarning);
                rep.getWriter().write(ewarning);
            }
        }
        else
        {
            System.out.println("保存了密码!");
            try {
                user_service.verify_by_MD5(user);
                model.addAttribute("userID", user_service.findUserID(user));
                rep.getWriter().write("./friend/redirect");
//                rep.sendRedirect("../friend/redirect");
            }
            catch (Exception e)
            {
                String[] ewarnings = e.toString().split(":");
                String ewarning = ewarnings[1];
                System.out.println(ewarning);
                rep.getWriter().write(ewarning);
            }
        }


    }

    @RequestMapping("/register")
    public void register(HttpServletRequest req, HttpServletResponse res,Model model) throws IOException {
            res.setCharacterEncoding("UTF-8");
        //2.直接规定浏览器看这份数据的时候，使用什么编码来看。
            res.setHeader("Content-Type", "text/html; charset=UTF-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = new User();
            user.setUsername(username);
            if(user_service.findUserID(user)!=-1){
                res.getWriter().write("用户名重复");
                return;
            }
            user.setPassword(password);
            user_service.saveUser(user);
            int user_id = user.getId();
            model.addAttribute("userID",user_id);
            res.getWriter().write("../friend/redirect");
        }


    @RequestMapping("/registerPage")
    public String register1(){
        return "register";
    }

}

