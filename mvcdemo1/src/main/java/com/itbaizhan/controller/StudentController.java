package com.itbaizhan.controller;

import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("id") int id){
        System.out.println("删除id为："+id+"的学生");
        return "wang";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findStudentById(@PathVariable int id){
        System.out.println(id);
        System.out.println("根据id查询学生");
        return "wang";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String addStudent(@PathVariable int id, Student student){
        System.out.println(id);
        System.out.println(student);
        System.out.println("新增学生");
        return "wang";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateStudent(@PathVariable int id, Student student){
        System.out.println(id);
        System.out.println(student);
        System.out.println("修改学生");
        return "wang";
    }
}
