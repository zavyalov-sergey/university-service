package com.zavyalov.universityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "group")
@Setter
@Getter
public class Group {

    @Id
    private UUID id;

    private String number;
}
