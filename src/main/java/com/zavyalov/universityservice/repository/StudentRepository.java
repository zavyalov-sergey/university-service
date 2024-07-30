package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    List<Student> findByUniGroup_Id(UUID uniGroupId);
}
