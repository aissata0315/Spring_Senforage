package sn.simplon.senforage.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {
    @RequestMapping(value = "/")
    public String index(){
        return "redirect:/logon";
    }
    @RequestMapping(value = "/logon")
    public String logon(ModelMap map, HttpServletRequest req, HttpServletResponse res){
        String user = req.getRemoteUser(); //recuperation email
        System.out.println("Principal is:" +user);

        if (user != null)
            return "client/client";
        else
            return "/login";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse res){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        return "redirect:/login?logout";
    }

    @RequestMapping(value = "/Admin/403")
    public String denied(){
        return "403";
    }
}
