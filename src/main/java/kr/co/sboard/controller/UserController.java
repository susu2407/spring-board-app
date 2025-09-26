package kr.co.sboard.controller;

import kr.co.sboard.config.AppInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @GetMapping("/user/info")
    public String info() {
        return "user/info";
    }

    @GetMapping("/user/login")
    public String login(){
        return "user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/user/terms")
    public String terms(){
        return "user/terms";
    }
}
