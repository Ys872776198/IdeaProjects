package com.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/**
 * @Auther: YS
 * @Date: 2021/10/30 21:33
 * @Description: IntelliJ IDEA
 * @Version: 1.0
 */

@Configuration
@ComponentScan("com")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
}
