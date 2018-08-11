package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserDetailsServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/KayitOl", method = RequestMethod.GET)
    public String getKayitOl(Model model) {
        model.addAttribute("userForm",new User());
        return "/KayitOl";
    }

    @RequestMapping(value ={"/KayitOl","/kayitOl"},method = RequestMethod.POST)
    public String postKayitOl(@ModelAttribute("userForm") User userForm)
    {

        String temprorayUUID = UUID.randomUUID().toString();

        User user= userForm;
        user.setActCode(temprorayUUID);
        userService.save(user);

        return "redirect:login";
    }

    @RequestMapping(value = {"/login","/UyeGiris"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "/login";
    }

    @RequestMapping(value={"/Hosgeldin"},method = RequestMethod.GET)
    public String Hosgeldin(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("user", userRepository.findUserByEmail(auth.getName()));
        return "/Hosgeldin";
    }

    @RequestMapping(value={"/profil","/Profil"},method = RequestMethod.GET)
    public String Profil(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("user", userRepository.findUserByEmail(auth.getName()));
        return "/profil";
    }
}
