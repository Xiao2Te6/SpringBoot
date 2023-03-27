package asia.xiaoer.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : XiaoEr
 * @date : 2023/3/9
 */

// @ResponseBody
// @Controller
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/")
    public String helloTst(){
        log.info("还行");
        return "hello springboot2 !";
    }
}
