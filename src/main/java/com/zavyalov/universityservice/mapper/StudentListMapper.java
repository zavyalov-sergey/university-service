package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public interface StudentListMapper {

    List<StudentDto> toDtoList(List<Student> students);
}
