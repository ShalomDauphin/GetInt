package com.Internships.GetInt.service;

import com.Internships.GetInt.model.Student;
import com.Internships.GetInt.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepo.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepo.findById(id);
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
        }else{
            throw  new RuntimeException("Student not found for id: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudent(long id) {
    this.studentRepo.deleteById(id);
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize,String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
        return this.studentRepo.findAll(pageable);
    }


}
