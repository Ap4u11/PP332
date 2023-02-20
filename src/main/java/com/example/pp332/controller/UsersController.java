package com.example.pp332.controller;

import com.example.pp332.model.User;
import com.example.pp332.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    private final UserServiceImp userServiceImp;

    @Autowired
    public UsersController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("usertable", userServiceImp.showUsers());
        return "users";
    }

    @GetMapping ("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user",user);
    return "user-info";
    }
    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user){
        userServiceImp.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userServiceImp.getUser(id));
        return "update";
    }
    @PatchMapping("/{id}")
    public String saveUpdateUser(@ModelAttribute("user") User user){
        userServiceImp.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id ){
        userServiceImp.delete(id);
        return "redirect:/users";
    }
}
