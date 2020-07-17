package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.service.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("panel")
    public String userPage(Model model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "table";
    }
}