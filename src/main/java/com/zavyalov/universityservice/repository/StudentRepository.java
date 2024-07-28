package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

}
