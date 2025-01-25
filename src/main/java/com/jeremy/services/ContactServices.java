package com.jeremy.services;

import com.jeremy.model.Contact;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Slf4j
@RequestScope
@Data
public class ContactServices {

    private int counter = 0;

    public ContactServices(){
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        // Todo - need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}
