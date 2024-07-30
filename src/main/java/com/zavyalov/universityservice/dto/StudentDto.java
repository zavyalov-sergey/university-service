package com.zavyalov.universityservice.dto;

import java.time.LocalDateTime;

public record StudentDto(
        String name,
        LocalDateTime acceptanceDate,
        String uniGroup
) {
}
