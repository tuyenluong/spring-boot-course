package com.jeremy.services;

import com.jeremy.constants.JeremySpringSchoolConstants;
import com.jeremy.model.Contact;
import com.jeremy.repository.ContactRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;

@Service
@Slf4j
@Data
@ApplicationScope
public class ContactServices {

    @Autowired
    private ContactRepository contactRepository;

    public ContactServices(){
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(JeremySpringSchoolConstants.OPEN);
        contact.setCreatedBy(JeremySpringSchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if (result > 0){
            isSaved=true;
        }
        return isSaved;
    }
}
