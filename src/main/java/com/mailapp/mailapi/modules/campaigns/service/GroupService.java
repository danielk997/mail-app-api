package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.GroupRepository;
import com.mailapp.mailapi.modules.campaigns.dto.GroupDTO;
import com.mailapp.mailapi.modules.campaigns.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public List<GroupDTO> getAll() {
        return groupRepository.findAll().stream().map(Group::buildDTOFromEntity)
                .collect(Collectors.toList());
    }
}
