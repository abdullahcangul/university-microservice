package com.cngl.universitystudent.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OneStudentUniversityDto {
    @ApiModelProperty(required = true)
    private int id;
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true,name = "founded_at",value ="founded_at" )
    private String founded_at;
    @ApiModelProperty(required = true)
    private String type;
}
