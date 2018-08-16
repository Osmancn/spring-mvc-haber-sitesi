package com.example.demo.controller;

import com.example.demo.model.Articles;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    @RequestMapping(value = {"/orders"} , method = RequestMethod.GET)
    public String code(@RequestParam("actCode") String active) {

        User a= new User();

        a = userRepository.findByActCode(active);
        // equalsIgnoreCase() Metodu: Temel olarak girilen string türünde bir ifadenin bir
        // başka string türünden ifade ile aynı olup olmadığını gösterir
        if (!a.getActCode().equalsIgnoreCase("")) {

            a.setValid(true);
            a.setRole("USER");
            userRepository.save(a);
        }
        return "/header";
    }

    @RequestMapping(value = {"/liste"}, method = RequestMethod.GET)
    public ModelAndView listAlien() {
        ModelAndView model = new ModelAndView("/liste");

        List<User> userList = (List<User>) userRepository.findAll();

        model.addObject("liste", userList);
        return model;
    }

    @RequestMapping(value = {"/profil/{id}/delete"})
    public String deleteUser(@PathVariable("id") int id, Model model) {

        userRepository.deleteById(id);
        List<User> userList = new ArrayList<>();
        userList = (List<User>) userRepository.findAll();
        model.addAttribute("liste", userList);
        return "/liste";
    }

    @RequestMapping(value = {"/profil/{id}/role/{role}"})
    public String RolDegis(@PathVariable("id") int id,
                           @PathVariable("role") String role, Model model) {

        userRepository.findUserById(id).setRole(role);
        List<User> userList = new ArrayList<>();
        userList = (List<User>) userRepository.findAll();
        model.addAttribute("liste", userList);
        return "/liste";
    }
    @RequestMapping(value="/haber",method = RequestMethod.GET)
    public String haber() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKEY", "0b6206c2f74e4cbd831128ca9ba132d8");
        String url = "https://api.hurriyet.com.tr/v1/articles";///40928802

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<List<Articles>> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Articles>>(){});
        List<Articles> articles = response.getBody();
        System.out.println(articles.size());

        return "/haber";
    }




}
