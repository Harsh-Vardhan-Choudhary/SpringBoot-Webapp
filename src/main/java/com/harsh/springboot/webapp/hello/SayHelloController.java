package com.harsh.springboot.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    //"say hello" -> "Hello! Padle bhai hello hello se job nahi milegi"

    //say-hello
    //http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! Padle bhai hello hello se job nahi milegi";
    }

    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My First HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first HTML page with body");
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
}
