package com.YS.Controller;

import com.YS.Dao.Impl.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: YS
 * @Date: 2021/11/10 20:30
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = {"/s"}, method = RequestMethod.GET, params = {"i=3"})
    public String save(){
        System.out.println("UserController Running!!!!!!!!!!!!!");
//        return "redirect:/success.jsp"; //redirect：重定向  forword：转发
//        在设置过前后缀之后：
        return "success"; //redirect：重定向  forword：转发
    }

//1、页面跳转，返回的是MoudelAndView：
//    Model 模型: 作用封装数据
//    view 视图: 作用展示数据
    @RequestMapping(value = {"/s2"})
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
//        设置model数据:在指定跳转的视图中利用 ${attributeName} 来接受收数据
//            如果出现页面跳转，model数据无法正常接收数据的原因：创建maven工程时，idea自动添加的web.xml中的jsp页面头约束版本太低
        modelAndView.addObject("username", "nene");
//        设置视图跳转:指定要跳转的页面的名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

//    Spring有自动注入功能，当扫描到需要入参时，Spring会帮我们提供一个相应的对象
    @RequestMapping(value = {"/s3"})
    public ModelAndView save3(ModelAndView modelAndView){
//        设置model数据:在指定跳转的视图中利用 ${attributeName} 来接受收数据
//            如果出现页面跳转，model数据无法正常接收数据的原因：创建maven工程时，idea自动添加的web.xml中的jsp页面头约束版本太低
        modelAndView.addObject("username", "Ys");
//        设置视图跳转:指定要跳转的页面的名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

//    可以将model和view拆开使用:最后的页面跳转，可是看作 modelAndView.setViewName("success"); 的另一种形式
    @RequestMapping(value = {"/s4"})
    public String save4(Model model){
        model.addAttribute("username", "Ys and nene");
        return "success";
    }

//    利用普通方法将数据保存到request域当中，然后在视图中反馈(不常用)
    @RequestMapping(value = {"/s5"})
//       第一步要有一个request域对象。在Spring框架中，在调用该方法时，Spring会更加形参，自动注入相应的对象
    public String save5(HttpServletRequest httpServletRequest){
//       第二步调用request对象的setAttribute方法，完成数据的传入
        httpServletRequest.setAttribute("username", "nene and Ys");
        return "success";
    }

//2、回写数据
//    返回字符串：
//    利用response.getWriter().print(" 字符串 ");
    @RequestMapping(value = {"/s6"})
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("s6");
    }

//    也可以将字符串直接返回给视图，但是需要告诉SpringMVC不能将前后缀加上，经行视图跳转，利用注解 @ResponseBody
    @RequestMapping(value = {"/s7"})
    @ResponseBody
    public String save7(){
        return "s7";
    }

//    返回对象和集合：
//    利用Json工具将对象转换为json格式的字符串，然后经行输出。先在pom.xml中导入json的包
    @RequestMapping(value = {"/s8"})
    @ResponseBody
    public String save8() throws JsonProcessingException {
        User user = new User();
        user.setUsername("haha");
        user.setAge(24);

//        利用Json工具将对象转换为json格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);
        return s;
    }

//    直接返回对象，不利用json工具，spring MVC自动将 对象 转换成json格式的字符串。先在spring-mvc.xml中配置一个处理器适配器
    @RequestMapping(value = {"/s9"})
    @ResponseBody
    public User save9(){
        User user = new User();
        user.setUsername("hahi");
        user.setAge(24);
        return user;
    }

    @RequestMapping(value = {"/s10"})
    @ResponseBody
    public String save10(){
        return "s7";
    }
}
