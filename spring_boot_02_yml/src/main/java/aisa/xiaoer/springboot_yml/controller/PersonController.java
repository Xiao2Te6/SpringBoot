package aisa.xiaoer.springboot_yml.controller;

import aisa.xiaoer.springboot_yml.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : XiaoEr
 * @date : 2023/3/27
 */
@Controller
public class PersonController {

    @Autowired
    private Person person;

    @ResponseBody
    @GetMapping("/")
    public Person personTest(){
        System.out.println(person);
        return person;
    }

}
