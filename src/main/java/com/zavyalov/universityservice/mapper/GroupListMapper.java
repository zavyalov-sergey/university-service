package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface GroupListMapper {

    List<GroupDto> toGroupDtoList(List<Group> groups);
}
