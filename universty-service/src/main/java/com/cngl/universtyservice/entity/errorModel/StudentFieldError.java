package com.cngl.universtyservice.entity.errorModel;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFieldError {

    private String key;
    private List<String> errors;

}
