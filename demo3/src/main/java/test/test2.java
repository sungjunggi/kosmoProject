package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test2 {

    @RequestMapping("/")
    public @ResponseBody String test(){
        return "test2";

    }
}
