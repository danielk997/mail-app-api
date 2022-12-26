package com.mailapp.mailapi.modules.campaigns.web;


import com.mailapp.mailapi.modules.campaigns.dto.CampaignDTO;
import com.mailapp.mailapi.modules.campaigns.dto.TemplateAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.TemplateDTO;
import com.mailapp.mailapi.modules.campaigns.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("templates")
public class TemplateController {

    private final TemplateService templateService;

    @GetMapping
    public List<TemplateDTO> getTemplates() {
        return templateService.getAll();
    }

    @PostMapping
    public TemplateDTO addTemplate(@RequestBody TemplateAddDTO dto) {
        return templateService.add(dto);
    }

    @PutMapping
    public TemplateDTO updateTemplate(@RequestBody TemplateDTO dto) {
        return templateService.update(dto);
    }
}
