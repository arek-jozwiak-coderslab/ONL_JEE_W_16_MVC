package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class SessionController {
    @GetMapping("/session1")
    @ResponseBody
    public String helloWorld(HttpSession session) {

        if (session.getAttribute("loginStart") != null) {
            return session.getAttribute("loginStart").toString();
        } else {
            session.setAttribute("loginStart", LocalDateTime.now().toString());
        }

        return "Hello World";
    }
}
