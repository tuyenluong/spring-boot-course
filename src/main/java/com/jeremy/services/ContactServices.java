package com.jeremy.services;

import com.jeremy.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactServices {

//    private static final Logger log = LoggerFactory.getLogger(ContactServices.class);

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        // Todo - need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }
}
