package com.mailapp.mailapi.modules.campaigns.web;

import com.mailapp.mailapi.modules.campaigns.dto.GroupAddDTO;
import com.mailapp.mailapi.modules.campaigns.dto.GroupDTO;
import com.mailapp.mailapi.modules.campaigns.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public GroupDTO getGroup(@PathVariable("id") Long id) {
        return groupService.getSingle(id);
    }

    @PostMapping()
    public GroupDTO add(@RequestBody GroupAddDTO dto) {
        return groupService.add(dto);
    }
}
