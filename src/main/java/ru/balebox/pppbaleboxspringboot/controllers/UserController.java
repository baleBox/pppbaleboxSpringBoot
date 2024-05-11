package ru.balebox.pppbaleboxspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.balebox.pppbaleboxspringboot.model.User;
import ru.balebox.pppbaleboxspringboot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/users")
    public String getAllUsers(@RequestParam(value = "alluser", required = false) String userlist, Model model) {
        model.addAttribute("users", userService.getAllUsers(userlist));
        return "users";
    }

    @GetMapping("/user_id")
    public String getUser(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("user", userService.getUserById(Long.parseLong(id)));
        return "show";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add_new_user";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @PostMapping("/edit_user")
    public String editUser(@RequestParam("id") String id, Model model) {
        model.addAttribute("user", userService.getUserById(Long.parseLong(id)));
        return "edit_user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @PostMapping("/delete_user")
    public String deleteUser(@RequestParam(value = "id") String id) {
        userService.deleteUser(Long.parseLong(id));
        return "redirect:/users";
    }
}
