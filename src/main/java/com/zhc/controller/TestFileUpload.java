package com.zhc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class TestFileUpload {

    @RequestMapping("/test1")
    @ResponseBody
    public void test1(String filename, MultipartFile file){
        System.out.println(filename);
        System.out.println(file);
    }

    @RequestMapping("/test2")
    @ResponseBody   //文件上传
    public void test2(String filename,MultipartFile file) throws IOException {
        System.out.println(filename);
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        file.transferTo( new File("C:/"+originalFilename));
    }

    @RequestMapping("/test3")
    @ResponseBody   //文件上传
    public void test3(String filename ,MultipartFile[] file) throws IOException {
        System.out.println(filename);
        for (MultipartFile multipartFile : file) {
            String originalFilename = multipartFile.getOriginalFilename();
            System.out.println(originalFilename);
            multipartFile.transferTo(new File("c:/"+originalFilename));
        }
    }
}
