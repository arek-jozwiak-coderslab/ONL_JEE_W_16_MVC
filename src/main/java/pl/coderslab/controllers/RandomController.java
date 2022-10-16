package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class RandomController {

    @GetMapping("/random/{max}/{min}")
    @ResponseBody
    public String random(@PathVariable int max, @PathVariable int min) {
        Random random = new Random();
        int val = random.nextInt(max - min) + min;
        return String.format("Użytkownik podał wartość %d. Wylosowano liczbę: %d.", max, val);
    }
}
