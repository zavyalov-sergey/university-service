package com.zavyalov.universityservice.repository;

import com.zavyalov.universityservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByUniGroup_Id(Long uniGroupId);
}
