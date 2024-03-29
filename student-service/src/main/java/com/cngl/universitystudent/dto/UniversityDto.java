package com.cngl.universitystudent.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDto implements Serializable {

    @ApiModelProperty(required = true)
    private int id;

    @ApiModelProperty(required = true)
    private String name;


}
