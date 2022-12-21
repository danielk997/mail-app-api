package com.mailapp.mailapi.modules.configuration.web;

import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationCreateDTO;
import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.service.SmtpConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("smtp-configurations")
public class SmtpConfigurationController {

    private final SmtpConfigurationService smtpConfigurationService;

    @GetMapping
    public List<SmtpConfigurationDTO> getAll() {
        return smtpConfigurationService.getAll();
    }

    @GetMapping("/{id}")
    public SmtpConfigurationDTO getById(@PathVariable("id") Long id) {
        return smtpConfigurationService.getById(id);
    }

    @PostMapping()
    public SmtpConfigurationCreateDTO add(@RequestBody SmtpConfigurationCreateDTO dto) {
        return smtpConfigurationService.create(dto);
    }
}
