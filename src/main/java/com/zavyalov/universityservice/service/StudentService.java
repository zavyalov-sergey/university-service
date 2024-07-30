package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.mapper.StudentListMapper;
import com.zavyalov.universityservice.mapper.StudentMapper;
import com.zavyalov.universityservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentListMapper studentListMapper;
    private final StudentMapper studentMapper;

    private static final String DELETE_MESSAGE = "Student deleted";

    public List<StudentDto> findAllByGroupId(Long id) {
        var students = studentRepository.findByUniGroup_Id(id);

        return studentListMapper.toDtoList(students);
    }

    @Transactional
    public StudentDto create(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);

        return studentMapper.toDto(studentRepository.save(student));
    }

    @Transactional
    public String delete(Long id) {
        studentRepository.deleteById(id);
        return DELETE_MESSAGE;
    }
}
