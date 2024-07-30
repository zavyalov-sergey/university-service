package com.zavyalov.universityservice.dto;

public record GroupDto(
        String id,
        String number,
        Integer studentsCount
) {

    @Override
    public Integer studentsCount() {
        return studentsCount != null ? studentsCount : 0;
    }
}
