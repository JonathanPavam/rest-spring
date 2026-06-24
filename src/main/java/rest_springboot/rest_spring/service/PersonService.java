package rest_springboot.rest_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_springboot.rest_spring.exception.ResourceNotFoundException;
import rest_springboot.rest_spring.model.Person;
import rest_springboot.rest_spring.repository.PersonRepository;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(Long id){
        logger.info("Finding person");
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
    }

    public Person create(Person person){
        return repository.save(person);
    }

    public Person update (Person person){
        Person entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }

    public void delete(Long id){
         Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
         repository.delete(entity);
    }
}

