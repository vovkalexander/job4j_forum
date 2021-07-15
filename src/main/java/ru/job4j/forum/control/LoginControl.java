package ru.job4j.forum.control;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class LoginControl {
    private final UserService users;

    public LoginControl(UserService users) {
        this.users = users;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("login")
    public String logIn(@ModelAttribute("user") User user, Model model ) {
        if (users.findByNameAndPassword(user.getUsername(), user.getPassword()) == null) {
            model.addAttribute("errorMessage", "Username or Password is incorrect");
            return "redirect:/login";
        }
        return "redirect:/index";
    }
}
