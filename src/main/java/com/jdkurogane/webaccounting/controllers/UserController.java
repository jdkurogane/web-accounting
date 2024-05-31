package com.jdkurogane.webaccounting.controllers;

import ch.qos.logback.core.model.Model;
import com.jdkurogane.webaccounting.models.User;
import com.jdkurogane.webaccounting.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "authPages/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "authPages/registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addText("Failed to create user");
            return "authPages/registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, org.springframework.ui.Model model) {
        model.addAttribute("user", user);
        model.addAttribute("transactions", user.getTransactions());
        return "userPages/user-info";
    }
}
