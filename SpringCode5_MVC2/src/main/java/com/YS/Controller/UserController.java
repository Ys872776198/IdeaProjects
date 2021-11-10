package com.YS.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: YS
 * @Date: 2021/11/10 20:30
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = {"/save","/s"}, method = RequestMethod.GET)
    public String save(){
        System.out.println("UserController Running!!!!!!!!!!!!!");
        return "redirect:/succeed.jsp"; //重定向
    }

}
