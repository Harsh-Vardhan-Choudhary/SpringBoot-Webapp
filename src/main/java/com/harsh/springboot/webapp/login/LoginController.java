package com.harsh.springboot.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        System.out.println("Request param is : " + name);       //not recomm for prod. code
        return "login";
    }
}
