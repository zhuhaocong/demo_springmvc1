package com.zhc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/tc1")
public class TestController1 {

    @RequestMapping("/test")
    public String test(){
        System.out.println("测试成功");
        return "success";
    }

/*-----------------------------------页面跳转-----------------------------------------*/
    @RequestMapping("/test1")
    public ModelAndView test1(){
        System.out.println("返回ModelAndView1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","test1");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/test2")
    public ModelAndView test2(ModelAndView modelAndView){
        System.out.println("返回ModelAndView2");
        modelAndView.addObject("username","test2");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/test3")
    public String test3(Model model){
        model.addAttribute("username","test3");
        return "success";
    }

    @RequestMapping("/test4")
    public String test4(HttpServletRequest request){
        request.setAttribute("username","test4");
        return "success";
    }

/*-----------------------------------回显数据-----------------------------------------*/
    @RequestMapping("/test5")
    public void test5(HttpServletResponse response) throws IOException {
        //对于响应乱码 乱码过滤器没用 需另外设置响应头如下或者：
        //配置@RequestMapping(value = "/test5",produces = "application/json;charset=UTF-8")
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("数据回显测试1");
    }

    @RequestMapping(value = "/test6"/*,produces = "application/json;charset=UTF-8"*/)
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String test6(HttpServletResponse response){
/*      失效 ：StringHttpMessageConverter设置的编码覆盖
        设置响应头，设置解码
        response.setHeader("Content-type","application/json;charset=UTF-8");
        设置编码
        response.setCharacterEncoding("UTF-8");

        解决办法：
        1.@RequestMapping(value = "/test8",produces = "application/json;charset=UTF-8")
        2.<mvc:annotation-driven ><mvc:message-converters>...<../><../>
          重点是修改StringHttpMessageConverter默认编码
*/
        return "数据回显测试2";
    }

    @RequestMapping("/test7")
    @ResponseBody
    public String test7(){
        return "{\"username\":\"test7\"}";
    }


    @RequestMapping(value = "/test8")
    @ResponseBody
    public String test8(HttpServletResponse response) throws IOException {
        User user = new User();
        user.setUsername("张三");
        user.setAge("15");
        ObjectMapper objectMapper=new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);
        return json;
    }

    @RequestMapping("/test9")
    @ResponseBody
    public User test9(){
        User user = new User();
        user.setUsername("李四");
        user.setAge("16");
        return user;
    }

}
