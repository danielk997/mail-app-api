package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.ViewRepository;
import com.mailapp.mailapi.modules.campaigns.dto.ViewDTO;
import com.mailapp.mailapi.modules.campaigns.model.View;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ViewService {

    private final ViewRepository viewRepository;

    public List<ViewDTO> getAll() {
        return viewRepository.findAllViews().stream().map(View::buildDTOFromEntity)
                .collect(Collectors.toList());
    }
}