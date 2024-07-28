package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.mapper.GroupListMapper;
import com.zavyalov.universityservice.mapper.GroupMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;
    private final GroupListMapper groupListMapper;

    @Transactional
    public GroupDto createGroup(GroupDto groupDto) {
        var group = groupMapper.toGroup(groupDto);

        return groupMapper.toDto(groupRepository.save(group));
    }

    public List<GroupDto> getAllGroups() {
        var groups = groupRepository.findAll();

        return groupListMapper.toDtoList(groups);
    }
}
