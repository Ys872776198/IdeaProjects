package com.YS.Listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @Auther: YS
 * @Date: 2021/11/5 23:26
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
public class WebContextLoderListener {
//    将servletContext.setAttribute("app", app);中的"app"和域里面保存的应用上下文对象进行解耦）
//    用静态方法进行修饰
    public static ApplicationContext getWebContextLoderListener(ServletContext servletContext){
        return (ApplicationContext)servletContext.getAttribute("app");
    }
}
