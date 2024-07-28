package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.Group;
import com.zavyalov.universityservice.entity.Student;
import com.zavyalov.universityservice.mapper.StudentListMapper;
import com.zavyalov.universityservice.mapper.StudentMapper;
import com.zavyalov.universityservice.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @Mock
    StudentMapper studentMapper;
    @Mock
    StudentListMapper studentListMapper;

    private Student student;
    private StudentDto studentDto;
    private List<Student> students;
    private List<StudentDto> studentDtos;

    @BeforeEach
    void setUp() {
        Group group = new Group();
        group.setNumber("14941");
        Date date = new Date(2024, 07, 28);

        student = new Student();
        student.setAcceptanceDate(date);
        student.setName("Molly");
        student.setGroup(group);

        studentDto = new StudentDto("Molly", date, "14941");

        students = List.of(student);
        studentDtos = List.of(studentDto);
    }

    @Test
    void findAllByGroupId() {
        when(studentRepository.findByGroup_Id(any())).thenReturn(students);
        when(studentListMapper.toDtoList(students)).thenReturn(studentDtos);

        var actual = studentService.findAllByGroupId(any());

        assertEquals(studentDtos, actual);
    }

    @Test
    void create() {
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(studentMapper.toDto(student)).thenReturn(studentDto);
        when(studentRepository.save(student)).thenReturn(student);

        var actual = studentService.create(studentDto);

        assertEquals(studentDto, actual);
    }

    @Test
    void delete() {
        doNothing().when(studentRepository).deleteById(any());

        var actual = studentService.delete(UUID.randomUUID());

        assertEquals("Student deleted", actual);
    }
}