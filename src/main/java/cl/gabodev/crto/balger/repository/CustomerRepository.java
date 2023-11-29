package cl.gabodev.crto.balger.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.gabodev.crto.balger.domain.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}