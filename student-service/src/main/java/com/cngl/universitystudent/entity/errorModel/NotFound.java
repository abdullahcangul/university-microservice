package com.cngl.universitystudent.entity.errorModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotFound {

    private String status;
    private String message;


}
