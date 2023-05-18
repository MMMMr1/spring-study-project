package com.spring.http.controller;

import com.spring.dto.UserReadDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {
    @GetMapping("/hello")
    public String hello(Model model,
                        HttpServletRequest request,
                        UserReadDto userReadDto){
        model.addAttribute("user", new UserReadDto(1L,"Ivan"));
        return "greeting/hello";
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

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user){
        ModelAndView modelAndView = new ModelAndView();
        return "greeting/bye";
    }
}
