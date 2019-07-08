package com.cngl.universitystudent.service;


import com.cngl.universitystudent.dto.OneStudentDto;
import com.cngl.universitystudent.dto.PostStudentDto;
import com.cngl.universitystudent.dto.PostStudentResponseDto;
import com.cngl.universitystudent.dto.StudentDto;
import com.cngl.universitystudent.entity.errorModel.ServiceResult;

import java.util.List;

public interface StudentService  {

    List<StudentDto> findAll();
    ServiceResult<OneStudentDto> getStudentById(int id) ;
    PostStudentResponseDto save(PostStudentDto postStudentDto);
}
