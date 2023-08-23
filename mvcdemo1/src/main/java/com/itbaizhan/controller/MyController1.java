package com.itbaizhan.controller;

import com.itbaizhan.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class MyController1
{
    // hello springmvc
    @RequestMapping("/c1/hello1")
    public void helloMVC(){
        System.out.println("hello SpringMVC！");
    }

    //获取参数值
    @RequestMapping("/c1/param1")
    public void simpleParam(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }


    // 获取单个对象
    @RequestMapping("/c1/param2")
    public void objParam(Student student){
        System.out.println(student);
    }

    // 获取关联对象
    @RequestMapping("/c1/param3")
    public void objParam2(Student student){
        System.out.println(student);
    }

    // 获取 集合
    @RequestMapping("/c1/param4")
    public void listParam(@RequestParam List<String> users){
        System.out.println(users);
    }

    // 获取数组
    @RequestMapping("/c1/param5")
    public void listParam2(@RequestParam String[] users){
        System.out.println(users[0]);
        System.out.println(users[1]);
    }

    // 自定义参数
    @RequestMapping("/c1/param6")
    public void dateParam(Date birthday){
        System.out.println(birthday);
    }


    /**
     * 返回值为void 跳转到方法路径名的试图
     */
    @RequestMapping("/helloMVC")
    public void helloSpringMVC(){
        System.out.println("hello SpringMVC");
    }

    /**
     * 返回值是String 跳转到名字是 前缀+返回值+后缀 的jsp页面
     * @return
     */
    @RequestMapping("/c2/hello1")
    public String helloMVC1(){
        System.out.println("hello SpringMVC");
        return "helloMVC";
    }

    /**
     * Model：向request域中设置数据。
     * View：指定跳转的页面。
     * @return
     */
    @RequestMapping("/modelandview")
    public ModelAndView useMAV(){
        System.out.println("model and view");
        ModelAndView modelAndView = new ModelAndView();
        Map<String,Object> model = modelAndView.getModel();
        model.put("name","wangzhixiong");
        modelAndView.setViewName("wang");
        return modelAndView;
    }


    /**
     * 测试空指针异常
     * @return
     */
    @RequestMapping("/error")
    public String error(){
        String str = null;
        str.length();
        return "index";
    }

    /**
     * 异常处理方法 处理空指针异常
     * @param ex 异常对象
     * @param model 模型对象
     * @return
     */
//    @ExceptionHandler(java.lang.NullPointerException.class)
//    public String exceptionHandler(Exception ex, Model model){
//        // 向模型中添加异常对象
//        model.addAttribute("msg",ex);
//        return "error";
//    }



    @RequestMapping("/interceptor")
    public String interceptor(){
        System.out.println("控制器方法");
        return "result";
    }
}
