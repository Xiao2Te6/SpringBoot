package asia.xiaoer.springboot.controller;

import asia.xiaoer.springboot.domain.Person;
import asia.xiaoer.springboot.domain.Pet;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

/**
 * @author : XiaoEr
 * @date : 2023/4/7
 *
 * 响应数据测试
 */
@Controller
public class ResponseTestController {

    @ResponseBody //利用RequestResponseBodyMethodProcessor返回值处理器里边 jackson的objectMapper把当前返回值对象转为JSON
    @GetMapping("/test/person")
    public Person getPerson(){
        return new Person("xiaoer",18 , "男",new Pet("huahua", 2));
    }


    @ResponseBody
    @GetMapping("/test/resource")
    public FileSystemResource getResource(){
        return new FileSystemResource(new File("E:\\Java\\my_all_project\\SpringBoot\\spring_boot_03_web\\src\\main\\resources\\static\\n4.jpg"));
    }
}
