package ee.sdacademy.thymeleaf.contacts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ee.sdacademy.thymeleaf.contacts.domain.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Integer> {

    List<Phone> findByContactId(Integer contactId);
}
