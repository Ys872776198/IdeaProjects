package Service.Impl;

import Dao.UserDao;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @Auther: YS
 * @Date: 2021/10/25 16:17
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */
//@Component("userService")  相当于 <bean id = "userService" class="Service.Impl.UserServiceImpl">
//在@Component("ID名")中，不需要填写全限定名，因为它就在这个类的里面。里面的ID名和bean标签的id作用一样
//    @Component("userService")
    @Service("userService")
    @Scope("singleton")
//    @Scope("prototype")
public class UserServiceImpl implements UserService {
//        <property name="userDao" ref="userDao"></property>
        @Autowired  //如果只有Autowired时，安装数据类型从Spring容器中进行匹配（它会自动去Spring容器中匹配UserDao类型的bean对象）
                    //如果同类型的bean对象不止一个，那么单独使用@Autowired会出问题
        @Qualifier("userDao")   //按照Id值在Spring容器中进行匹配，同时还要配合@Autowired使用
//        @Resource(name = "userDao") //@Resource = @Autowired + @Qualifier
//        使用注解时，可以不用set方法进行注入，将注解放到属性上时，Spring会自动给属性赋值
    private Dao.UserDao UserDao;

//        注入普通值
//    @Value("nene")
//    也可以注入已经在applicationContex.xml设置过的.properties文件
    @Value("${jdbc.username}")
    private String s;

//        使用注解时，可以不用set方法进行注入，将注解放到属性上时，Spring会自动给属性赋值
//    public void setUserDao(Dao.UserDao userDao) {
//        UserDao = userDao;
//    }

    public UserServiceImpl() {
        System.out.println("UserServiceImpl创建了！！！！");
    }

    @Override
    public void save() {
        System.out.println("s:" + s);
        UserDao.save();
        System.out.println("hello UserService!!!");
    }

    @PostConstruct  //指定Bean的初始化方法,相当于init-method="方法"
    public void Inti(){
        System.out.println("我初始化了！！！");
    }

    @PreDestroy //指定Bean的销毁方法，相当于destroy-method="方法"
    public void Destory(){
        System.out.println("我销毁了！！！！");
    }
}
