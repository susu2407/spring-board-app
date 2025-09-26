package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FindController {

    @PostMapping("/find/changePassword")
    public String changePassword() {
        return "find/changePassword";
    }

    @PostMapping("/find/password")
    public String password() {
        return "find/password";
    }

    @GetMapping("/find/resultUserId")
    public String resultUserId() {
        return "find/resultUserId";
    }

    @GetMapping("/find/userId")
    public String userId() {
        return "find/userId";
    }
}
