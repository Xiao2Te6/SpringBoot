package asia.xiaoer.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : XiaoEr
 * @date : 2023/4/1
 */

@Controller
public class ParameterTestController {

    @ResponseBody
    @GetMapping("/user/{id}/pet/{petName}")
    public Map<String,Object> getUsers(@PathVariable("id") String id,
                                      @PathVariable("petName")String petName,
                                      @PathVariable Map<String, String> pv,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("gender") String gender,
                                      @RequestParam Map rp,
                                      @RequestHeader Map header,
                                      @CookieValue("Idea-52310fa0") String sCookie,
                                      @CookieValue("Idea-52310fa0") Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("petName", petName);
        map.put("pv", pv);
        map.put("age", age);
        map.put("gender", gender);
        map.put("rp", rp);
        map.put("header", header);
        map.put("sCookie", sCookie);
        map.put("cookie", cookie);
        return map;
    }

    @ResponseBody
    @PostMapping("/user/save")
    public Map<String, Object> saveUser(@RequestBody String name){
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        System.out.println("map = " + map);
        return map;
    }

    /**
     *矩阵变量
     *  springboot默认仅用了矩阵变量,使用之前需要配置webMvcConfigurer，关闭urlPathHelper(路径解析) 中setRemoveSemicolonContent(自动移除路径分号后内容)的功能
     *  矩阵变量必须由url路径变量才能 使用
     */
    @ResponseBody
    @GetMapping("/user/{path}") // /user/id;name=xiaowang;pet=xiaohua,xiaohei,xiaobai
    public Map<String, Object> getUser(@MatrixVariable("name")String name,
                                       @MatrixVariable("pet")List<String> pet,
                                       @PathVariable("path")String path){
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("pet",pet);
        map.put("path",path);
        return map;
    }

    @ResponseBody
    @GetMapping("/user/{userId}/{petId}") // /user/1;age=18/2;age=2
    public Map<String, Object> getUser2(@MatrixVariable(value = "age",pathVar = "userId") Integer userAge,
                                        @MatrixVariable(value = "age", pathVar = "petId") Integer petAge){
        Map<String, Object> map = new HashMap<>();
        map.put("userAge",userAge);
        map.put("petAge",petAge);
        return map;
    }

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("name", "xiaoer");
        request.setAttribute("password", "123");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(HttpServletRequest request,
                                       @RequestAttribute("name") String name,
                                       @RequestAttribute("password") String password){

        // Object name = request.getAttribute("name");
        // Object password = request.getAttribute("password");

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("password", password);
        return map;
    }
}
