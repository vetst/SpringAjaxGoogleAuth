package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/*")
public class AdminController {

    private UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping("admin/users")
    public ResponseEntity<List<User>> getUsersTable(Model model, HttpSession session) {
        return new ResponseEntity<List<User>>(service.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("admin/add")
    public void addUser(@RequestParam String firstName, String lastName, String password, String email, int age, String role) {
        service.addUser(new User(firstName, lastName, password, email, age), role);
    }

    @PostMapping("admin/delete")
    public String deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return "redirect:/admin/panel";
    }

    @PostMapping("admin/update")
    public void updateUser(@RequestParam Long id, String firstName, String lastName, String password, String email, int age, String role) {
        password = service.ifPasswordNull(id, password);
        service.updateUser(new User(id, firstName, lastName, password, email, age), role);
    }

    @GetMapping("user/getUser")
    public ResponseEntity<List<User>> getUser(HttpSession session) {
        List<User> userList = new ArrayList<>();
        User user = (User) session.getAttribute("user");
        userList.add(user);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
