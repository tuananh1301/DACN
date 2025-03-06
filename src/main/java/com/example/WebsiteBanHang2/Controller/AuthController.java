package com.example.WebsiteBanHang2.Controller;

import com.example.WebsiteBanHang2.Exception.AppException;
import com.example.WebsiteBanHang2.Model.LoginForm;
import com.example.WebsiteBanHang2.Model.RegisterRequest;
import com.example.WebsiteBanHang2.Model.UserAccount;
import com.example.WebsiteBanHang2.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new RegisterRequest());
        return "Auth/Register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("userForm") RegisterRequest form, Model model) {
        try {
            authService.register(form);
            return "redirect:/login";
        } catch (AppException e) {
            model.addAttribute("error", e);
            return "Auth/Register";
        }
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "Auth/login";
    }

}
