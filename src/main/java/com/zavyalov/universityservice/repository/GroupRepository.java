package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
