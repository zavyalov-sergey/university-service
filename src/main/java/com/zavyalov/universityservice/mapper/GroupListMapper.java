package com.zavyalov.universityservice.mapper;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.UniGroup;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = GroupMapper.class)
public interface GroupListMapper {
    List<GroupDto> toDtoList(List<UniGroup> uniGroups);
}
