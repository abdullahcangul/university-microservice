package com.cngl.universtyservice.service;

import com.cngl.universtyservice.dto.UniversityDetailDto;
import com.cngl.universtyservice.dto.UniversityDto;
import com.cngl.universtyservice.entity.University;
import com.cngl.universtyservice.entity.errorModel.ServiceResult;

import java.util.List;

public interface UniversityService {
    List<UniversityDetailDto> findAll();
    ServiceResult<UniversityDetailDto> getUniversity(int id);
    University save(University universities);
    List<University> getAllUniversity();
}
