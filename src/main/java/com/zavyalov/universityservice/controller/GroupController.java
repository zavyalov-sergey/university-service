package com.zavyalov.universityservice.controller;

import com.zavyalov.universityservice.dto.GroupDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupController {

    @GetMapping
    public Page<GroupDto> getGroups() {

        return null;
    }

    @PostMapping
    public void createGroup(
            @RequestBody GroupDto groupDto
    ) {

    }
}
