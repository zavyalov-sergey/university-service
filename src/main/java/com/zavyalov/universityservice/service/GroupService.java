package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.Group;
import com.zavyalov.universityservice.mapper.GroupListMapper;
import com.zavyalov.universityservice.mapper.GroupMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Group group = groupMapper.toGroup(groupDto);

        groupRepository.save(group);

        return groupMapper.toGroupDto(group);
    }

    public List<GroupDto> getAllGroups() {
        List<Group> groups = groupRepository.findAll();

        return groupListMapper.toGroupDtoList(groups);
    }
}
