package com.Internships.GetInt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String names;
    private String yearOfBirth;
    private String email;
    private String mobileNumber;
    private String gender;
    private String occupation;
    private String nationality;
    private String fieldOfStudy;
    private String schoolName;
    private String yearOfGrad;
    private String gpa;
    private String numberOfSemester;


}
