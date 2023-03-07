package team.wbt.newzips.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() { return "hello"; }

    @GetMapping("/")
    public String index() { return "Project Newzips RESTAPI v2"; }
}
