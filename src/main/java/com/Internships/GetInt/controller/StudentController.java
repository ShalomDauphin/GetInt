package com.Internships.GetInt.controller;

import com.Internships.GetInt.model.Student;
import com.Internships.GetInt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String viewListPage(Model model){
//        model.addAttribute("listStudents", studentService.getAllStudents());
//        return "list";
        return  findPaginated(1,"names", "asc", model);
    }

        @GetMapping("/showStudentForm")
    public String showStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/list";
    }

    @GetMapping("/showStudentUpdateForm/{id}")
    public String showFormUpdate(@PathVariable(value = "id")long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id")long id){
        this.studentService.deleteStudent(id);
        return "redirect:/list";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,  Model model){
        int pageSize = 5;
        Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Student> listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listStudents", listStudents);
        return "list";
    }
}
