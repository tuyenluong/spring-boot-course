package com.jeremy.services;

import com.jeremy.constants.JeremySpringSchoolConstants;
import com.jeremy.model.Contact;
import com.jeremy.repository.ContactRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Optional;

@Service
@Slf4j
@Data
@ApplicationScope
public class ContactServices {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus(JeremySpringSchoolConstants.OPEN);
        Contact result = contactRepository.save(contact);
        if (result != null && result.getContactId() > 0){
            isSaved=true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                JeremySpringSchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){
        boolean isUpdated = false;

        Optional<Contact> contactOptional = contactRepository.findById(contactId);
        contactOptional.ifPresent(contact -> {
            contact.setStatus(JeremySpringSchoolConstants.CLOSE);
        });
        Contact result = contactRepository.save(contactOptional.get());
        if(result != null && result.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
