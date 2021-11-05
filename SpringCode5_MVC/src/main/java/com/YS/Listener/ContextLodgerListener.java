package com.YS.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: YS
 * @Date: 2021/11/4 23:36
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

//设置监听器
public class ContextLodgerListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
////        自定义：
//        ServletContext servletContext = sce.getServletContext();
////        在设置好Web全局变量后：
////        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
////        改为：ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocationg);
//        String contextConfigLocationg = servletContext.getInitParameter("contextConfigLocationg");
//        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocationg);
//
////        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
////        将Spring应用上下文对象（ApplicationContext对象）放到最大的域ServletContext中,
////        利用ServletContextEvent类的getServletContext()方法（利用入参实现）
//
//        servletContext.setAttribute("app", app);
//        System.out.println("我创建了ServletContext域");

//        利用Spring提供的设置
        ServletContext servletContext = sce.getServletContext();
        String contextConfigLocationg = servletContext.getInitParameter("contextConfigLocationg");
        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocationg);
        servletContext.setAttribute("app", app);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
