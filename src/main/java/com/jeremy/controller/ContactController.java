package com.jeremy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {

    // Because we might have use case for the user to fill in contact form
    // Therefore it's necessary to add more functionality
    // for the user to submit form

    @RequestMapping("/contact")
    public String displayContactPage(){
        return "contact.html";
    }

}
