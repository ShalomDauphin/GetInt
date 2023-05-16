package com.Internships.GetInt.repository;

import com.Internships.GetInt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
