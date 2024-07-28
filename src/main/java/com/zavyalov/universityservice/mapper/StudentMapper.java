package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
     StudentDto toDto(Student student);

     Student toStudent(StudentDto studentDto);
}
