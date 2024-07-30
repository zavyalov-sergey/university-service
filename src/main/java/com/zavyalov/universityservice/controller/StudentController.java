package com.zavyalov.universityservice.controller;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllByGroupId(
            @RequestParam("groupId") String groupId) {
        return ResponseEntity
                .ok()
                .body(studentService.findAllByGroupId(Long.parseLong(groupId)));
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(
            @RequestBody StudentDto studentDto) {
        return ResponseEntity
                .ok()
                .body(studentService.create(studentDto));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(
            @RequestParam String id) {
        return ResponseEntity
                .ok()
                .body(studentService.delete(Long.parseLong(id)));
    }
}
