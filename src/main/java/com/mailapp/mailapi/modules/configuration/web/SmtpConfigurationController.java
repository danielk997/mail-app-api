package com.mailapp.mailapi.modules.configuration.web;

import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.service.SmtpConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("smtp-configurations")
public class SmtpConfigurationController {

    private final SmtpConfigurationService smtpConfigurationService;

    @CrossOrigin
    @GetMapping
    public List<SmtpConfigurationDTO> getAll() {
        return smtpConfigurationService.getAll();
    }
}
