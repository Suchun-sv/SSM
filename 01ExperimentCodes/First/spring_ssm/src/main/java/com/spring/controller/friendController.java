package com.spring.controller;

import com.spring.domain.Friend;
import com.spring.domain.User;
import com.spring.service.friendService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/friend")
@SessionAttributes("user")
public class friendController{
    @Autowired
    private friendService friend_service;

    @RequestMapping("/main")
    public String my_friends(HttpSession session, Model model, HttpServletResponse resp) throws IOException {
//        int user_id = (String) session.getAttribute("user");
        int user_id = 1;
        try {
            user_id = (int) session.getAttribute("userID");
            System.out.println("userID:"+String.valueOf(user_id));
//            System.out.println(user_id);
        }catch (Exception e){
            resp.sendRedirect("../");
        }
        List<Friend> b= friend_service.findAll(user_id);
        model.addAttribute("user", b);
        return "main";
    }
    @RequestMapping("/searchMain")
    public String serviceMain(HttpSession session, Model model, HttpServletResponse res) throws IOException {
        int user_id = 1;
        try {
            user_id = (int) session.getAttribute("userID");
            System.out.println("userID:"+String.valueOf(user_id));
//            System.out.println(user_id);
        }catch (Exception e){
            res.sendRedirect("../");
        }
        List<Friend> f = (List<Friend>) session.getAttribute("user");
        System.out.println(f);
        model.addAttribute("user", f);
        return "main";
    }
    @RequestMapping("/post/alter")
    public void alter_post(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        String[] ids = req.getParameterValues("post");
//        for(int i=0;i<ids.length;i++)
//        {
//            System.out.println(ids[i]);
//        }
        String id = req.getParameter("id");
        String name = req.getParameter("friend_name");
        String birth = req.getParameter("friend_birth");
        String gender = req.getParameter("gender");
        String phoneNum = req.getParameter("phoneNum");
        String weChat = req.getParameter("friend_wechat");
        String QQ = req.getParameter("friend_QQ");
        String address = req.getParameter("friend_address");
        Friend friend = new Friend(name, birth, gender, phoneNum, weChat, QQ, address, 1);
        friend.setId(Integer.valueOf(id).intValue());
        System.out.println(friend);
        if (friend_service.alterFriend(friend)) {
//            res.setStatus(200);
            res.getWriter().write("success! ");
        } else {
//            res.setStatus(400);
            res.getWriter().write("error, please contact Administrator!");
        }
    }
    @RequestMapping("/post/findByLikeName")
    public void search(HttpServletResponse res, HttpServletRequest rep, HttpSession session, Model model) throws IOException {
        String name = rep.getParameter("name");
        int user_id = (int)session.getAttribute("userID");
        List<Friend> f = friend_service.findByLikeName(name, user_id);
        model.addAttribute("user", f);
        session.setAttribute("user", f);
        res.getWriter().write("./searchMain");
    }

    @RequestMapping("/post/add")
    public void add_post(HttpServletResponse res, HttpServletRequest req, HttpSession session) throws IOException {
        int user_id = (int)session.getAttribute("userID");
        String name = req.getParameter("friend_name");
        String birth = req.getParameter("friend_birth");
        String gender = req.getParameter("gender");
        String phoneNum = req.getParameter("phoneNum");
        String weChat = req.getParameter("friend_wechat");
        String QQ = req.getParameter("friend_QQ");
        String address = req.getParameter("friend_address");
        Friend friend = new Friend(name, birth, gender, phoneNum, weChat, QQ, address,user_id);
//        friend.setId(Integer.valueOf(id).intValue());
        System.out.println(friend);
        if (friend_service.saveFriend(friend)) {
//            res.setStatus(200);
            System.out.println("登录成功");
            res.getWriter().write("success! ");
        } else {
//            res.setStatus(400);
            System.out.println("登录失败");
            res.getWriter().write("error, please contact Administrator!");
        }
    }

    @RequestMapping("/test")
    public @ResponseBody User jsontest(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/post/delete")
    public void delete_post(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        System.out.println("删除被启动了");
        String[] ids = req.getParameterValues("post");
        res.setHeader("Content-type", "text/html;charset=UTF-8");
        res.setCharacterEncoding("UTF-8");
        if(ids.length<1){
            res.getWriter().write("您未选择任何需要删除的行");
        }
        for(int i=0;i<ids.length;i++)
        {
            if(friend_service.delById(Integer.valueOf(ids[i]).intValue())){
//                res.getWriter().write("你在做啥子?!");
                res.getWriter().write("删除成功！");
            }else {
                res.getWriter().write(String.valueOf(i)+"删除失败!");
            }
        }

    }
    @RequestMapping("/redirect")
    public String redirect(HttpServletResponse resp,HttpSession session) throws IOException {
        try {
            int user_id = (int) session.getAttribute("userID");
        }catch (Exception e){
            resp.sendRedirect("../");
        }
        return "redirect";
    }
    }




