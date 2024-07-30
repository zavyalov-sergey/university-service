package com.zavyalov.universityservice.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record StudentDto(
        String name,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime acceptanceDate,
        String uniGroup
) {
}
