package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.UniGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupRepository extends JpaRepository<UniGroup, Long> {

    @Query("SELECT g.id, g.number, COUNT(s) FROM UniGroup g LEFT JOIN Student s ON g.id = s.uniGroup.id GROUP BY g.id, g.number")
    List<Object[]> getUniGroups();
}
