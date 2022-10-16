package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class HelloController {
    private static final Logger log
            = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
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
