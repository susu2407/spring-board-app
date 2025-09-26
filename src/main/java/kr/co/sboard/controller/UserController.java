package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/user/info")
    public String info() {
        return "user/info";
    }

    @PostMapping("/user/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/user/register")
    public String register() {
        return "user/register";
    }

    @GetMapping("/user/terms")
    public String terms() {
        return "user/terms";
    }
}
