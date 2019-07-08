package com.cngl.universtyservice.api;

import java.util.List;

import com.cngl.universtyservice.dto.UniversityDetailDto;
import com.cngl.universtyservice.entity.University;
import com.cngl.universtyservice.entity.errorModel.ServiceResult;
import com.cngl.universtyservice.service.UniverstyServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UniversityController
 */
@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final UniverstyServiceImpl universityService;

    public UniversityController(UniverstyServiceImpl universityService) {
        this.universityService = universityService;
    }

    // Kayıtlı bütün üniversiteleri getiren kod blogu
    @GetMapping(value = "")
    public ResponseEntity<List<UniversityDetailDto>> getAllUniversities() {

        return ResponseEntity.ok(universityService.findAll());
    }

    @GetMapping(value = "/apiget")
    public ResponseEntity<List<University>> getAllUniversitiesByApi() {

        return ResponseEntity.ok(universityService.getAllUniversity());
    }
    
    //id si verilen üniversiteyi döndüren kod blogu
    @GetMapping(value = "/{id}")
    public ResponseEntity getUniversity(@PathVariable(value="id",required = true) int id){

        ServiceResult<UniversityDetailDto> serviceResult=universityService.getUniversity(id);
        //id si verilen üniversite bulunamadıgında döndürülen kod blogu
       // if (serviceResult.getNotFound()!=null)
          //  return new ResponseEntity<>(serviceResult.getNotFound(), HttpStatus.NOT_FOUND);
          
        return ResponseEntity.ok(serviceResult.getResult());

    }


}