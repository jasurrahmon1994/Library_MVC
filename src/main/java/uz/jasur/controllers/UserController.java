package uz.jasur.controllers;

import org.springframework.web.bind.annotation.*;
import uz.jasur.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import uz.jasur.models.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("users", userDAO.showAllUsers());
        return "users/all";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "users/id";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
//        @Valid Person person, BindingResult bindingResult
//        if (bindingResult.hasErrors())
//            return "people/new";

        userDAO.save(user);
        return "redirect:/users/all";
    }

}
