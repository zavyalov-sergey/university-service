package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.Student;
import com.zavyalov.universityservice.entity.UniGroup;
import com.zavyalov.universityservice.mapper.StudentListMapper;
import com.zavyalov.universityservice.mapper.StudentMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import com.zavyalov.universityservice.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private GroupRepository groupRepository;
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
        UniGroup uniGroup = new UniGroup();
        uniGroup.setNumber("14941");
        LocalDateTime date = LocalDateTime.of(2024, 7, 30, 0, 0, 0);

        student = new Student();
        student.setAcceptanceDate(date);
        student.setName("Molly");
        student.setUniGroup(uniGroup);

        studentDto = new StudentDto("Molly", date, "14941");

        students = List.of(student);
        studentDtos = List.of(studentDto);
    }

    @Test
    void findAllByGroupId() {
        when(studentRepository.findByUniGroup_IdOrderByAcceptanceDateDesc(any())).thenReturn(students);
        when(studentListMapper.toDtoList(students)).thenReturn(studentDtos);

        var actual = studentService.findAllByGroupId(any());

        assertEquals(studentDtos, actual);
    }

    @Test
    void create() {
        when(studentMapper.toStudent(studentDto)).thenReturn(student);
        when(groupRepository.findById(any(Long.class))).thenReturn(Optional.of(student.getUniGroup()));
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.toDto(student)).thenReturn(studentDto);

        var actual = studentService.create(studentDto);

        assertEquals(studentDto, actual);
    }

    @Test
    void delete() {
        Long studentId = 1L;
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

        String actualMessage = studentService.delete(studentId);

        assertEquals("Student deleted", actualMessage);
    }
}