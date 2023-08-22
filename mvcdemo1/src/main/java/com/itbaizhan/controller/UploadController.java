package com.itbaizhan.controller;

import org.apache.commons.fileupload.FileItem;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UploadController
{
    @RequestMapping("/fileUpload")
    public String upload(HttpServletRequest request) throws Exception {
        // 创建文件夹，存放上传文件
        // 1.设置上传文件夹的真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        System.out.println(realPath);
        // 2.判断该目录是否存在，如果不存在，创建该目录
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }


        // 分析请求体，找到上传文件数据
        // 1.创建磁盘文件工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2.创建上传数据分析器对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
        // 3.利用分析器对象解析请求体，返回所有数据项
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);
        // 4.遍历所有数据，找到文件项（非表单项）
        for (FileItem fileItem:fileItems){
            if(!fileItem.isFormField()){
                // 将文件数据写入文件夹
                // 1.获取文件名
                String name = fileItem.getName();
                // 2.将文件写入磁盘
                fileItem.write(new File(file,name));
                // 3.删除内存中的临时文件
                fileItem.delete();
            }
        }
        return "index";
    }


    @RequestMapping("/fileUpload2")
    public String upload2(MultipartFile file,HttpServletRequest request) throws IOException
    {
        // 创建文件夹，存放上传文件
        // 1.设置上传文件夹的真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        System.out.println(realPath);
        // 2.判断该目录是否存在，如果不存在，创建该目录
        File fileDir = new File(realPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        String filename = file.getOriginalFilename();
        filename = UUID.randomUUID()+"_"+filename;
        File newFile = new File(fileDir, filename);
        file.transferTo(newFile);

        return "index";
    }


    @RequestMapping("/fileUpload3")
    public String upload3(MultipartFile[] files,String username,HttpServletRequest request) throws IOException
    {
        System.out.println(username);
        // 创建文件夹，存放上传文件
        // 1.设置上传文件夹的真实路径
        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        System.out.println(realPath);
        // 2.判断该目录是否存在，如果不存在，创建该目录
        File fileDir = new File(realPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        for(MultipartFile file : files){
            String filename = file.getOriginalFilename();
            filename = UUID.randomUUID()+"_"+filename;
            System.out.println(filename);
            File newFile = new File(fileDir, filename);
            file.transferTo(newFile);
        }
        return "index";
    }
}
