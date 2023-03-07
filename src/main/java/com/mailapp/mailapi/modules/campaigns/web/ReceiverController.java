package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.PersonAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.PersonDTO;
import com.mailapp.mailapi.modules.campaigns.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("receivers")
public class ReceiverController {

    private final PersonService personService;

    @GetMapping
    public List<PersonDTO> getAllReceivers() {
        return personService.getAll();
    }

    @PostMapping()
    public PersonDTO add(@RequestBody PersonAddDTO dto) {
        return personService.add(dto);
    }

    @PutMapping()
    public PersonDTO update(@RequestBody PersonAddDTO dto) {
        return personService.add(dto);
    }
}
