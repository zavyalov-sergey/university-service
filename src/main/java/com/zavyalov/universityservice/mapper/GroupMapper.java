package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    
    GroupDto toGroupDto(Group group);

    Group toGroup(GroupDto groupDto);
}
