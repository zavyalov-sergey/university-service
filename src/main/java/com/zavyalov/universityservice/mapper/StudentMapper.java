package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.Group;
import com.zavyalov.universityservice.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StudentMapper {
     @Mapping(target = "group", qualifiedByName = "toDtoMapping")
     StudentDto toDto(Student student);

     @Mapping(target = "group", qualifiedByName = "toEntityMapping")
     Student toStudent(StudentDto studentDto);

     @Named("toDtoMapping")
     default String toDtoMapping(Group group) {
          return group.getNumber();
     }

     @Named("toEntityMapping")
     default Group toEntityMapping(String string) {
          Group group = new Group();
          group.setNumber(string);
          return group;
     }
}
