package ru.job4j.forum.control;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

@Controller
public class RegControl {
    private final PasswordEncoder encoder;
    private final UserService users;
    private final AuthorityRepository authorities;

    public RegControl(PasswordEncoder encoder, UserService users,
                      AuthorityRepository authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute User user) {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        if (users.existsByName(user.getUsername())) {
            model.addAttribute("errorMessage", "Inputted username is already existed");
            return "reg";
        }
        users.addUser(user);
        return "redirect:/login";
    }
}
