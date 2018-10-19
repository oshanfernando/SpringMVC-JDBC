package com.spring.controller;

import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(Model model){
        model.addAttribute("command",new User());
        return "loginpage";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String login(@ModelAttribute("command")User user, Model model){
        String name = userService.verifyUser(user.getEmail(),user.getPassword());

        if (name != "") {

            model.addAttribute("name",name);
            return "test";
        }
        else
        {
            model.addAttribute("error","Invalid Username or Password");
            return "loginpage";
        }
    }

    @RequestMapping(value = "/createuser",method = RequestMethod.GET)
    public String showRegisterPage(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, Model model){
        int status = this.userService.createAccount(user);

        if(status==1){
            model.addAttribute("msg","Account Created !");
        }
        else {
            model.addAttribute("err","Failed to create account !");
        }

        return "register";
    }
}
