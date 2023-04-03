package asia.xiaoer.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author : XiaoEr
 * @date : 2023/3/27
 */
@Controller
public class IndexController {

    // sringboot
    // @ResponseBody
    // @GetMapping("/n4.jpg")
    // public String indexTest(){
    //     return "aaa";
    // }

    @GetMapping("/user")
    @ResponseBody
    public String getUser(){
        return "获取全部user";
    }


    @PostMapping("/user")
    @ResponseBody
    public String saveUser(){
        return "保存user";
    }



    @DeleteMapping("/user")
    @ResponseBody
    public String deleteUser(){
        return "删除全部user";
    }



    @PutMapping("/user")
    @ResponseBody
    public String putUser(){
        return "更新全部user";
    }


}
