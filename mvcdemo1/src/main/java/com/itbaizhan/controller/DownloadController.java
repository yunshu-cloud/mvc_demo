package com.itbaizhan.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class DownloadController
{
    // 查询可下载的文件
    @RequestMapping("/showFiles")
    public String showFileDown(HttpServletRequest request, Model model){
        //1.获取下载文件路径集合。注：跨服务器上传中，网络路径无法获取文件列表。
        String path = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(path);
        File file = new File(path);
        String[] files = file.list();
        System.out.println(files);
        //2.将路径放入模型中，跳转到JSP页面
        model.addAttribute("files",files);
        return "download";
    }


    // 文件下载
    @RequestMapping("/download")
    public void fileDown(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException
    {
        // 设置响应头
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        // 获取文件路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File file = new File(path,fileName);
        // 获取字节输出流
        ServletOutputStream os = response.getOutputStream();
        // 使用输出流写出文件
        os.write(FileUtils.readFileToByteArray(file));
        os.flush();
        os.close();
    }


}
