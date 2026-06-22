package rest_springboot.rest_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_springboot.rest_spring.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
