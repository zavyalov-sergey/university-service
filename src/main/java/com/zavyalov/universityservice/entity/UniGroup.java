package com.zavyalov.universityservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "uni_group")
@Setter
@Getter
public class UniGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "number", nullable = false)
    private String number;
}
