package asia.xiaoer.springboot;

import asia.xiaoer.springboot.beans.Car;
import asia.xiaoer.springboot.beans.Cat;
import asia.xiaoer.springboot.config.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author : XiaoEr
 * @date : 2023/3/9
 */
@SpringBootApplication //标识一个主程序类，说明这是一个Spring Boot应用
public class MainApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        Cat cat = run.getBean(Cat.class);
        Cat cat2 = run.getBean(Cat.class);
        System.out.println(cat == cat2);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有
        SpringConfig bean = run.getBean(SpringConfig.class);
        Cat cat3 = bean.cat();
        System.out.println("cat3 == cat2 : " + (cat3 == cat2));


        Car car = run.getBean(Car.class);
        System.out.println("car = " + car);
    }
}
