package com.sharueigo.thymeleaftest.controllers;

import com.sharueigo.thymeleaftest.model.Profile;
import com.sharueigo.thymeleaftest.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
public class GeneralController {

    @InitBinder
    public void setAllowedFields(WebDataBinder binder){
        binder.setDisallowedFields("pass2");
    }

    @RequestMapping("/profile")
    public ModelAndView profileController(){
        Profile profile = Profile.builder()
                .title("Mr")
                .firstName("Matt")
                .surname("Greencroft")
                .dateOfBirth(new GregorianCalendar(2006, Calendar.APRIL,9).getTime())
                .description("a <strong>fantastic</strong> java programmer")
                .build();
        return new ModelAndView("profile")
                    .addObject("profile",profile);
    }

    @GetMapping("/newUser")
    public ModelAndView getNewUser(){
        return new ModelAndView("newUser")
                .addObject("user",new User());
    }

    @PostMapping("/newUser")
    public ModelAndView saveNewUser(@Valid @ModelAttribute User user, BindingResult result){
        if(result.hasErrors()){
            System.out.println("ERRORZ POZZZ");
            return new ModelAndView("newUser")
                        .addObject("user",user);
        }
        System.out.println(user);
        return new ModelAndView("newUser")
                    .addObject("user",new User());
    }
}
