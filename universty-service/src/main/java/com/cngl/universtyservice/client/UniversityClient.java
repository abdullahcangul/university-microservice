package com.cngl.universtyservice.client;


import com.cngl.universtyservice.dto.UniversityDto;
import com.cngl.universtyservice.entity.University;
import feign.RequestLine;

import java.util.List;

public interface UniversityClient {

    @RequestLine("GET ")
    List<University> getAllUniversity();

}
