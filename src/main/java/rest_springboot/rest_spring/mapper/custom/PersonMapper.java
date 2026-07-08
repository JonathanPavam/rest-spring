package rest_springboot.rest_spring.mapper.custom;

import org.springframework.stereotype.Service;
import rest_springboot.rest_spring.data.dto.v2.PersonDTOV2;
import rest_springboot.rest_spring.model.Person;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDTOV2 convertEntityToDTO(Person person) {
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthDay(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());
        return dto;
    }

    public Person convertDtoToEntity(PersonDTOV2 person) {
        Person entity = new Person();
        entity.setId(entity.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        //entity.setBirthDay(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
