package com.Internships.GetInt.service;

import com.Internships.GetInt.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List <Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudent(long id);
    Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
