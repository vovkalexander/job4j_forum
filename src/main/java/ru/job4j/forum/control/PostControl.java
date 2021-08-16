package ru.job4j.forum.control;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.UserRepository;

@Controller
public class PostControl {
    private final PostService posts;
    private final UserService users;

    public PostControl(PostService posts, UserService users) {
        this.posts = posts;
        this.users = users;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        User user = users.findUser(SecurityContextHolder.getContext().getAuthentication()
                .getName());
        post.setUser(user);
        posts.addPost(post);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "edit";
    }

    @GetMapping("/post")
    public String getPost(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "post";
    }

    @PostMapping("/add")
    public String addComment(@RequestParam("id")  int id, @RequestParam("comment") String comment) {
        posts.addComment(id, comment);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/comment")
    public String showComment(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", posts.findById(id));
        return "comment";
    }
}
