package rest_springboot.rest_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest_springboot.rest_spring.data.dto.v1.PersonDTO;
import rest_springboot.rest_spring.data.dto.v2.PersonDTOV2;
import rest_springboot.rest_spring.exception.ResourceNotFoundException;
import static rest_springboot.rest_spring.mapper.ObjectMapper.parseListObjects;
import static rest_springboot.rest_spring.mapper.ObjectMapper.parseObject;

import rest_springboot.rest_spring.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper converter;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<PersonDTO> findAll(){
        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id){
        logger.info("Finding person");
        var entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
    return parseObject(entity, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person)
    {
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createv2(PersonDTOV2 person)
    {
        logger.info("Creating one Person v2");
        var entity = converter.convertDtoToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update (PersonDTO person){
        Person entity = repository.findById(person.getId())
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
         Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this id"));
         repository.delete(entity);
    }
}

