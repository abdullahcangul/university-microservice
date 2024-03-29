package com.cngl.universtyservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(nullable = false,length = 100)
    private String name;


    @Column(nullable = false,name = "started_at")
    private LocalDate started_at;


    @ManyToOne(optional=true,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    private University university;



}
