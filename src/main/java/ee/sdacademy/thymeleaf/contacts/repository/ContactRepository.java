package ee.sdacademy.thymeleaf.contacts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ee.sdacademy.thymeleaf.contacts.domain.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findAll();
}
