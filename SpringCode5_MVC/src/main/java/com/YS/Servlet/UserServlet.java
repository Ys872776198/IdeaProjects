package com.YS.Servlet;

import com.YS.Listener.WebContextLoderListener;
import com.YS.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
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
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService us = (UserService)app.getBean("userService");
//        us.save();

//        将Spring应用上下文对象的创建设置到监听器中，同时将ApplicationContext对象放到ServletContext域中
//        调用方法：
//            1、利用入参的HttpServletRequest对象,调用getServletContext()方法(利用自定义)
//        ServletContext sc = req.getServletContext();
////        ApplicationContext app = (ApplicationContext) sc.getAttribute("app");
////        在将"app"与域里面的应用上下文对象进行解耦之后
////        ApplicationContext app = (ApplicationContext) sc.getAttribute("app");
////        变为：ApplicationContext app = WebContextLoderListener.getWebContextLoderListener(sc);
//        ApplicationContext app = WebContextLoderListener.getWebContextLoderListener(sc);
//        UserService us = (UserService)app.getBean("userService");
//        us.save();

//            2、利用this(利用Spring提供的设置)
//        ServletContext sc = this.getServletContext();
//        ApplicationContext app = (ApplicationContext) sc.getAttribute("app");
//        UserService us = (UserService)app.getBean("userService");
//        us.save();
        ServletContext servletContext = this.getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService us = (UserService)app.getBean("userService");
        us.save();
    }
}
