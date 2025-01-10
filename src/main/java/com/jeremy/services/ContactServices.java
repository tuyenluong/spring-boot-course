package com.jeremy.services;

import com.jeremy.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactServices {

    private static final Logger log = LoggerFactory.getLogger(ContactServices.class);

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        // Todo - need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}
