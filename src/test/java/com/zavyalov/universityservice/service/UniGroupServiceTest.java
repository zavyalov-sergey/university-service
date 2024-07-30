package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.UniGroup;
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
class UniGroupServiceTest {

    @InjectMocks
    private GroupService groupService;

    @Mock
    private GroupRepository groupRepository;
    @Mock
    private GroupMapper groupMapper;
    @Mock
    private GroupListMapper groupListMapper;

    private UniGroup uniGroup;
    private GroupDto groupDto;
    private List<UniGroup> uniGroups;
    private List<GroupDto> groupDtos;

    @BeforeEach
    void setUp() {
        uniGroup = new UniGroup();
        uniGroup.setNumber(groupDto.number());

        //groupDto = new GroupDto("14941");

        uniGroups = List.of(uniGroup);
        groupDtos = List.of(groupDto);
    }

    @Test
    void createGroup() {
        when(groupMapper.toGroup(groupDto)).thenReturn(uniGroup);
        when(groupMapper.toDto(any(UniGroup.class))).thenReturn(groupDto);
        when(groupRepository.save(uniGroup)).thenReturn(uniGroup);

       // var actual = groupService.createGroup(groupDto);

        //assertEquals(groupDto, actual);
    }

    @Test
    void getGroups() {
        when(groupRepository.findAll()).thenReturn(uniGroups);

        when(groupListMapper.toDtoList(uniGroups)).thenReturn(groupDtos);

        var actual = groupService.getGroups();

        assertEquals(groupDtos, actual);
    }
}