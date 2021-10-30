package com.YS.Servlet;

import com.YS.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: YS
 * @Date: 2021/10/30 23:30
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext cc = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService)cc.getBean("userService");
        us.save();
    }
}
