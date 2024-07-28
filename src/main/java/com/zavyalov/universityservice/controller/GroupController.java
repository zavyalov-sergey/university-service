package com.zavyalov.universityservice.controller;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;

    @GetMapping
    public ResponseEntity<List<GroupDto>> getGroups() {
        return ResponseEntity
                .ok()
                .body(groupService.getGroups());
    }

    @PostMapping
    public ResponseEntity<GroupDto> createGroup(
            @RequestBody GroupDto groupDto) {
        return ResponseEntity
                .ok()
                .body(groupService.createGroup(groupDto));
    }
}