package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.TemplateRepository;
import com.mailapp.mailapi.modules.campaigns.dto.TemplateAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.TemplateDTO;
import com.mailapp.mailapi.modules.campaigns.model.Template;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TemplateService {

    private final TemplateRepository templateRepository;

    public List<TemplateDTO> getAll() {
        return templateRepository.findAll().stream().map(Template::buildDTOFromEntity).collect(Collectors.toList());
    }

    public TemplateDTO add(TemplateAddDTO dto) {
        Template addedEntity = templateRepository.saveAndFlush(dto.generateEntityFromDTO());

        return addedEntity.buildDTOFromEntity();
    }
}
