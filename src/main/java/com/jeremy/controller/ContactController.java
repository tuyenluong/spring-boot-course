package com.jeremy.controller;

import com.jeremy.model.Contact;
import com.jeremy.services.ContactServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactServices contactServices;

    @Autowired
    public ContactController(ContactServices contactServices){
        this.contactServices = contactServices;
    }

    // Because we might have use case for the user to fill in contact form
    // Therefore it's necessary to add more functionality
    // for the user to submit form

    @RequestMapping("/contact")
    public String displayContactPage(){
        return "contact.html";
    }

//    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
//    public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
//                                    @RequestParam String email, @RequestParam String subject, @RequestParam String message){
//        log.info("Name: "+name);
//        log.info("Mobile Number: "+mobileNum);
//        log.info("Email Address: "+email);
//        log.info("Subject: "+subject);
//        log.info("Message: "+message);
//        return new ModelAndView("redirect:/contact");
//    }

    @PostMapping(value = "/saveMsg")
    public ModelAndView saveMessage(Contact contact){
        contactServices.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }
}
