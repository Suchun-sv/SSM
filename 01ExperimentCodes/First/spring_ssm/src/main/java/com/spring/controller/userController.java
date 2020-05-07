package com.spring.controller;

import com.spring.domain.User;
import org.apache.ibatis.annotations.ResultMap;
//import org.graalvm.compiler.api.replacements.MethodSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.service.userService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService user_service;

    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    private HttpServletResponse response;

    @RequestMapping(value = "/login")
    @ResponseBody
    public void login(String username, String password, String is_remembered, HttpServletRequest req, HttpServletResponse rep) throws IOException {
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
                rep.getWriter().write("登录成功!");
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
                rep.getWriter().write("登录成功! by Cookie");
            }
            catch (Exception e)
            {
                String[] ewarnings = e.toString().split(":");
                String ewarning = ewarnings[1];
                System.out.println(ewarning);
                rep.getWriter().write(ewarning);
//                return "login";
            }
        }

//        return "login";
    }

}
