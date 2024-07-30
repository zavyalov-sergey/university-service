package com.zavyalov.universityservice.service;

import com.zavyalov.universityservice.dto.GroupDto;
import com.zavyalov.universityservice.entity.UniGroup;
import com.zavyalov.universityservice.mapper.GroupMapper;
import com.zavyalov.universityservice.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    public List<GroupDto> getGroups() {
        return groupRepository.getUniGroups()
                .stream()
                .map(group -> new GroupDto(
                        (String) group[0],
                        (String) group[1],
                        (Integer) group[2]
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public GroupDto createGroup(String number) {
        var group = new UniGroup();

        System.out.println(number);
        group.setNumber(number);

        var savedGroup = groupRepository.save(group);

        System.out.println(
                savedGroup
        );
        return groupMapper.toDto(savedGroup);
    }
}
