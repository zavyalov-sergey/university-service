package com.zavyalov.universityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;
import java.util.UUID;

@Entity(name = "student")
public class Student {

    @Id
    private UUID id;

    private String name;

    private Date acceptanceDate;
}
