package com.zavyalov.universityservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "acceptance_date", nullable = false)
    private LocalDateTime acceptanceDate;

    @ManyToOne
    @JoinColumn(name = "uni_group_id", referencedColumnName = "id")
    private UniGroup uniGroup;
}
