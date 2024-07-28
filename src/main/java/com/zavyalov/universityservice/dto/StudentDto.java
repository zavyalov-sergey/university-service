package com.zavyalov.universityservice.dto;

import java.util.Date;

public record StudentDto(
        String name,
        Date acceptanceDate,
        String group
) {
}
