package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.StudentDto;
import com.zavyalov.universityservice.entity.UniGroup;
import com.zavyalov.universityservice.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface StudentMapper {
     @Mapping(target = "uniGroup", qualifiedByName = "toDtoMapping")
     StudentDto toDto(Student student);

     @Mapping(target = "uniGroup", qualifiedByName = "toEntityMapping")
     Student toStudent(StudentDto studentDto);

     @Named("toDtoMapping")
     default String toDtoMapping(UniGroup uniGroup) {
          return uniGroup.getNumber();
     }

     @Named("toEntityMapping")
     default UniGroup toEntityMapping(String string) {
          UniGroup uniGroup = new UniGroup();
          uniGroup.setNumber(string);
          return uniGroup;
     }
}
