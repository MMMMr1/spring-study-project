package com.spring.http.controller;

import com.spring.database.entity.Role;
import com.spring.dto.UserReadDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {
    @ModelAttribute("roles")
    public List<Role> roles(){
        return Arrays.asList(Role.values());
    }
    @GetMapping("/hello")
    public String hello(Model model,
                        HttpServletRequest request,
                        UserReadDto userReadDto){
        model.addAttribute("user", userReadDto);
        return "greeting/hello";
    }
    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user, Model model){
        return "greeting/bye";
    }
    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView,
                              HttpServletRequest request,
                              @RequestParam Integer age,
                              @RequestHeader String accept,
                              @PathVariable("id") Integer id
    ){
        String ageParamValue = request.getParameter("age");
        String acceptHeader = request.getHeader("accept");
        Cookie[] cookies = request.getCookies();
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }
}
