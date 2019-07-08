package com.cngl.universitystudent.client;


import com.cngl.universitystudent.dto.UniversityDto;
import com.cngl.universitystudent.entity.University;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UniversityClient {

    @RequestLine("GET /{id}")
    University getByApiId(@Param("id") long id);

    @RequestLine("GET /apiget")
    List<University> getAllUniversity();

}
