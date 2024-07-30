package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.UniGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupRepository extends JpaRepository<UniGroup, UUID> {
}
