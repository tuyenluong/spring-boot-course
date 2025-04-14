package com.jeremy.controller;

import com.jeremy.model.Contact;
import com.jeremy.services.ContactServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Controller
public class ContactController {

    private final ContactServices contactServices;

    @Autowired
    public ContactController(ContactServices contactServices){
        this.contactServices = contactServices;
    }

    // Because we might have use case for the user to fill in contact form
    // Therefore it's necessary to add more functionality
    // for the user to submit form

    @RequestMapping("/contact")
    public String displayContactPage(Model model){
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

    @PostMapping(value = "/saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors){
        if(errors.hasErrors()){
            log.error("Contact form validation failed due to: " + errors.toString());
            return "contact.html";
        }
        contactServices.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "10") int size) {
        Page<Contact> contactMsgs = contactServices.findMsgsWithOpenStatus(PageRequest.of(page, size, Sort.by("email").ascending()));
        ModelAndView modelAndView = new ModelAndView("messages.html");

        modelAndView.addObject("contactMsgs", contactMsgs.getContent()); // Pass paginated data
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", contactMsgs.getTotalPages());
        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg",method = GET)
    public String closeMsg(@RequestParam int id) {
        contactServices.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }
}
