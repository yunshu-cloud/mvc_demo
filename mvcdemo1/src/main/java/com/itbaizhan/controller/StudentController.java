package com.itbaizhan.controller;

import com.itbaizhan.domain.Result;
import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String addStudent1(@PathVariable int id, Student student){
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


    @PostMapping("/addStudent")
    @ResponseBody //方法返回的对象转换为JSON格式，并将JSON数据直接写入到输出流中，使用此注解后不会再经过视图解析器。使用该注解可以处理Ajax请求。
    public Result addStudent(String name, String sex) {
        // 输出接受到的参数，模拟添加学生
        System.out.println(name+":"+sex);
        // 返回添加结果
        Result result = new Result(true, "添加学生成功！");
        return result;
    }
}
