package asia.xiaoer.springboot.controller;

import asia.xiaoer.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : XiaoEr
 * @date : 2023/4/4
 *
 *  springboot复杂参数和servlet api测试
 */
@Controller
public class RequestController {

    //自定义参数测试
    @ResponseBody
    @PostMapping("/person")
    public Person savePerson(Person person){
        return person;
    }

    @GetMapping("/test/hello")
    public String test(Model model, Map<String, Object> map, ModelMap modelMap, HttpServletRequest request){
        request.setAttribute("hello1", "hello request");
        model.addAttribute("hello2", "hello model");
        map.put("hello3", "hello map");
        modelMap.addAttribute("hello4", "hello modelMap");
        return "forward:/hello";
    }

    @ResponseBody
    @GetMapping("/hello")
    public Map hello(HttpServletRequest request){
        Object hello1 = request.getAttribute("hello1");
        Object hello2 = request.getAttribute("hello2");
        Object hello3 = request.getAttribute("hello3");
        Object hello4 = request.getAttribute("hello4");

        Map hashMap = new HashMap();
        hashMap.put("hello1", hello1);
        hashMap.put("hello2", hello2);
        hashMap.put("hello3", hello3);
        hashMap.put("hello4", hello4);
        return hashMap;
    }
}
