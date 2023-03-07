package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.PersonRepository;
import com.mailapp.mailapi.modules.campaigns.dto.PersonAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.PersonDTO;
import com.mailapp.mailapi.modules.campaigns.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonDTO> getByGroupId(Long id) {
        return personRepository.findByGroupId(id).stream().map(Person::buildDTOFromEntity).collect(Collectors.toList());
    }

    public List<PersonDTO> getAll() {
        return personRepository.findAll().stream().map(Person::buildDTOFromEntity)
                .toList();
    }

    public PersonDTO add(PersonAddDTO dto) {
        Person addedEntity = personRepository.saveAndFlush(dto.generateEntityFromDTO());

        return addedEntity.buildDTOFromEntity();
    }
}
