package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.UniGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<UniGroup, Long> {
}
