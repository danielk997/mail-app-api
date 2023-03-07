package com.mailapp.mailapi.modules.campaigns.service;

import com.mailapp.mailapi.modules.campaigns.dao.GroupRepository;
import com.mailapp.mailapi.modules.campaigns.dto.GroupAddDTO;
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
    private final PersonService personService;

    public List<GroupDTO> getAll() {
        return groupRepository.findAll().stream().map(Group::buildDTOFromEntity)
                .collect(Collectors.toList());
    }

    public GroupDTO getSingle(Long id) {
        GroupDTO groupDTO = groupRepository.findById(id).get().buildDTOFromEntity();
        groupDTO.setReceivers(personService.getByGroupId(id));
        return groupDTO;
    }

    public GroupDTO add(GroupAddDTO dto) {
        Group addedEntity = groupRepository.saveAndFlush(dto.generateEntityFromDTO());
        dto.getReceivers().forEach(it -> {
            groupRepository.addLinkToPersons(addedEntity.getId(), it.getId());
        });

        return addedEntity.buildDTOFromEntity();
    }
}
