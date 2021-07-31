package BiLiExcisesCodes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @Auther: YS
 * @Date: 2021/7/30
 * @Description: (接E71,E72,E73,E74)
 * @Version: 1.0
 */

/**
 * 元注解
 * @Target:表示注解能修饰那些东西
 * @Retention：定义注解的生命周期。RUNTIME表示运行时。
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface E69_Annotation {
    String value();             //属性
}
