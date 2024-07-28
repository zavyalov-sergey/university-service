package com.zavyalov.universityservice.controller;

import com.zavyalov.universityservice.dto.GroupDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @GetMapping
    public List<GroupDto> getGroups() {

        return null;
    }

    @PostMapping
    public void createGroup(
            @RequestBody GroupDto groupDto
    ) {

    }
}
