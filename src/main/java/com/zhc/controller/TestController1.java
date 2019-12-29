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
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("数据回显测试1");
    }

    @RequestMapping(value = "/test6",produces = "application/json;charset=UTF-8")
    @ResponseBody//告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public String test6(){
        return "数据回显测试2";
    }

    @RequestMapping("/test7")
    @ResponseBody
    public String test7(){
        return "{\"username\":\"test7\"}";
    }


    /*Bug：关于@ResponseBody 处理返回值为String类型的数据；此时在对应的类中设置了响应头以及编码还是final的
    * 所以乱码拦截器无效、在此方法内设置编码也无效。需要在之后的@RequestMapping中设置produces
    * */
    @RequestMapping(value = "/test8",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String test8(HttpServletResponse response) throws IOException {
/*      失效
        response.setHeader("Content-type","application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
*/
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
