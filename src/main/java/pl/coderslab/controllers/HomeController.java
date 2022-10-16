package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class HomeController {

    private static final Logger log
            = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    @ResponseBody
    public String doSth(){

        log.debug("asd {} , doasdoas {}", 3, 4);
        return "Hofffffffffff";
    }

    @GetMapping("/qweqw")
    @ResponseBody
    public String doSthSecond(){

        log.debug("asd {} , doasdoas {}", 3, 4);
        return "Hofffffffffff";
    }

    @PostMapping("/homeeeee")
    @ResponseBody
    public String doSthPost(){
        return "Home asd asd asd asd ";
    }
}
