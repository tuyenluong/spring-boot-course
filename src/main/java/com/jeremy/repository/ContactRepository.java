package com.jeremy.repository;

import com.jeremy.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    Page<Contact> findByStatus(String status, Pageable pageable);
}
