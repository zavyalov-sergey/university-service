package com.zavyalov.universityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "group")
public class Group {

    @Id
    private UUID id;

    private String number;
}
