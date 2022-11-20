package com.mailapp.mailapi.modules.configuration.service;

import com.mailapp.mailapi.modules.configuration.dao.SmtpConfigurationRepository;
import com.mailapp.mailapi.modules.configuration.dto.SmtpConfigurationDTO;
import com.mailapp.mailapi.modules.configuration.model.SmtpConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SmtpConfigurationService {

    private final SmtpConfigurationRepository smtpConfigurationRepository;

    public SmtpConfigurationDTO getActiveConfiguration() {
        return smtpConfigurationRepository.getSmtpConfigurationByActive(true).buildDTOFromEntity();
    }

    public List<SmtpConfigurationDTO> getAll() {
        return smtpConfigurationRepository.findAll().stream().map(SmtpConfiguration::buildDTOFromEntity).collect(Collectors.toList());
    }
}
