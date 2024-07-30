package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.UniGroup;
import com.zavyalov.universityservice.mapper.GroupMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
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

    private UniGroup group;
    private GroupDto groupDto;

    @BeforeEach
    void setUp() {
        group = new UniGroup();
        group.setNumber("14941");

        groupDto = new GroupDto("", "14941", 0);

    }

    @Test
    void createGroup() {
        when(groupRepository.save(any(UniGroup.class))).thenReturn(group);
        when(groupMapper.toDto(any(UniGroup.class))).thenReturn(groupDto);

        GroupDto result = groupService.createGroup(groupDto.number());

        assertEquals(groupDto.number(), result.number());
    }

    @Test
    void testGetGroups() {
        List<Object[]> mockGroups = List.of(
                new Object[]{1L, "14941", 5},
                new Object[]{2L, "14942", 3}
        );
        when(groupRepository.getUniGroups()).thenReturn(mockGroups);

        List<GroupDto> result = groupService.getGroups();

        assertEquals(2, result.size());
    }
}