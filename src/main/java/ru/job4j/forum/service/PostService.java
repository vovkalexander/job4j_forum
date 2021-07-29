package ru.job4j.forum.service;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.time.LocalDate;
import java.util.*;

@Service
public class PostService    {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public Collection<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void addPost(Post post) {
        posts.save(post);
    }

    public Post findById(int id) {
        return this.posts.findById(id).get();
    }

    public Collection<String> findAllComment(int id) {
        return this.findById(id).getDiscussion();
    }

    public void addComment(int id, String comment) {
        Post post = posts.findPostById(id);
        post.getDiscussion().add(comment);
        posts.save(post);
    }
}
