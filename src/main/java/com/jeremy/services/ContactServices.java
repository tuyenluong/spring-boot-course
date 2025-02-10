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
import java.util.List;

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

    public List<Contact> findMsgsWithOpenStatus(){
        return contactRepository.findMsgsWithStatus(JeremySpringSchoolConstants.OPEN);
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,JeremySpringSchoolConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
