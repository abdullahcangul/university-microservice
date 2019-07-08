package com.cngl.universtyservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversityDetailDto {

    @ApiModelProperty(required = true)
    private int id;

    @ApiModelProperty(required = true,value = "api_id")
    private int apiId;

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(required = true)
    private String city;
    @ApiModelProperty(required = true,name ="web_page",value = "web_page")
    private String web_page;

    @ApiModelProperty(required = true)
    private String type;

    @ApiModelProperty(required = true,name = "founded_at",value = "founded_at")
    private String founded_at;


    private List<UniversityDetailStudentDto> students;
}
