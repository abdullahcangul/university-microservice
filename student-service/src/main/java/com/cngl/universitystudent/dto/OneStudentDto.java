package com.cngl.universitystudent.dto;


import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneStudentDto {

    private int id;

    private String name;

    private LocalDate started_at;

    private OneStudentUniversityDto university;

    public String getStarted_at() {
        return started_at.toString();
    }
}
