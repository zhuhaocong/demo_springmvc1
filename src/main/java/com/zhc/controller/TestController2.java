package com.zhc.controller;

import com.zhc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/tc2")
public class TestController2 {

    @RequestMapping("/test1")
    @ResponseBody   //http://localhost/tc2/test1?username=zhangsan&age=15
    public void test1(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/test2")
    @ResponseBody   //http://localhost/tc2/test2?username=zhangsan&age=15
    public void test2(User user){
        System.out.println(user);
    }

    @RequestMapping("/test3")
    @ResponseBody   //http://localhost/tc2/test2?name=zhangsan&name=lisi&name=wangwu
    public void test3(String[] name){
        System.out.println(Arrays.asList(name));
    }

    @RequestMapping("/test4")
    @ResponseBody   //form
    public void test4(Users users){
        System.out.println(users);
    }

    @RequestMapping("/test5")
    @ResponseBody   //ajax  @RequestBody 解析json格式字符串
    public void test5(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping("/test6")
    @ResponseBody   //@RequestParam 将传递的变量名绑定到参数上
    public void test6(@RequestParam(value = "username", required = false,defaultValue = "赵日天") String name, String age){
        System.out.println(name);
        System.out.println(age);
    }

    @RequestMapping("/test7/{name}")
    @ResponseBody   //@PathVariable 绑定占位符与参数
    public void test7(@PathVariable(value = "name") String username){
        System.out.println(username);
    }

    @RequestMapping("/test8")
    @ResponseBody   //自定义类型转换器 并且在xml文件中配置 配置一个工厂bean 并在mvc注解驱动标签中指定使用修改后的工厂
    public void test8(Date date){
        System.out.println(date);
    }

    @RequestMapping("/test9")
    @ResponseBody   //支持原始servletAPI作为参数
    public void test9(HttpServletResponse response, HttpServletRequest request, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping("/test10")
    @ResponseBody   //可获取请求头信息
    public void test10(@RequestHeader(value = "User-Agent", required = false) String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping("/test11")
    @ResponseBody
    public void test11(@CookieValue(value = "JSESSIONID") String jsessionid){
        System.out.println(jsessionid);
    }

}
