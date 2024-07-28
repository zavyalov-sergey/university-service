package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.Group;
import com.zavyalov.universityservice.mapper.GroupListMapper;
import com.zavyalov.universityservice.mapper.GroupMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {

    @InjectMocks
    private GroupService groupService;

    @Mock
    private GroupRepository groupRepository;
    @Mock
    private GroupMapper groupMapper;
    @Mock
    private GroupListMapper groupListMapper;

    private Group group;
    private GroupDto groupDto;
    private List<Group> groups;
    private List<GroupDto> groupDtos;

    @BeforeEach
    void setUp() {
        group = new Group();
        group.setNumber(groupDto.number());

        groupDto = new GroupDto("14941");

        groups = List.of(group);
        groupDtos = List.of(groupDto);
    }

    @Test
    void createGroup() {
        when(groupMapper.toGroup(groupDto)).thenReturn(group);
        when(groupMapper.toDto(any(Group.class))).thenReturn(groupDto);
        when(groupRepository.save(group)).thenReturn(group);

        var actual = groupService.createGroup(groupDto);

        assertEquals(groupDto, actual);
    }

    @Test
    void getGroups() {
        when(groupRepository.findAll()).thenReturn(groups);

        when(groupListMapper.toDtoList(groups)).thenReturn(groupDtos);

        var actual = groupService.getGroups();

        assertEquals(groupDtos, actual);
    }
}