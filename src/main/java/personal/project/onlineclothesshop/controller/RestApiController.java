package personal.project.onlineclothesshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RestApiController {
    @GetMapping(path = "/home")
    public String home() {
        return "Hello";
    }

}
