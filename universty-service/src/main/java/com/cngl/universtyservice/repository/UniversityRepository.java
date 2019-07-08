package com.cngl.universtyservice.repository;

import com.cngl.universtyservice.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University,Integer> {

    List<University> findAll();
    University getByApiId(int id);
    University getById(int id);
}
