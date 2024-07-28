package com.zavyalov.universityservice.controller;

import com.zavyalov.universityservice.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public Page<StudentDto> findByGroup(
            String groupId) {
        return null;
    }

    @PostMapping
    public StudentDto add(
            @RequestBody StudentDto studentDto
    ) {
        return null;
    }

    @DeleteMapping
    public StudentDto delete(String id) {
        return null;
    }
}
