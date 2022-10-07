package uz.jasur.controllers;

import uz.jasur.dao.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
