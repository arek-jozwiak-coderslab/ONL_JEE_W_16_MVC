package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class HelloController {
    private static final Logger log
            = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld(HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookie2");
        return "Hello World";
    }

    @RequestMapping("/session2")
    @ResponseBody
    public String session2(HttpSession ses) {
        int sesMax = (int)ses.getAttribute("max");

        System.out.println(sesMax);
        return "session";
    }

    @GetMapping("/helloView")
    public String helloView(Model model) {
        String backgroundColor = "white";
        String color = "black";
        log.debug("now {}", LocalDateTime.now().getHour());
        if (LocalDateTime.now().getHour() > 13 || LocalDateTime.now().getHour() < 8) {
            backgroundColor = "black";
            color = "white";
        }
        log.debug("backgroundColor {} color {}", backgroundColor, color);
        model.addAttribute("backgroundColor", backgroundColor);
        model.addAttribute("color", color);
        return "home";
    }
}
