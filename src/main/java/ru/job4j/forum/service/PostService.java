package ru.job4j.forum.service;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService    {
    private final HashMap<Integer, Post> posts = new HashMap<>();
    private AtomicInteger key = new AtomicInteger(1);

    public PostService() {
        posts.put(1, Post.of(1,"Продаю машину ладу 01.", "Б/У", LocalDate.now()));

    }

    public Collection<Post> getAll() {
      return this.posts.values();
    }


    public void addPost(Post post) {
        if (post.getId() == 0) {
            post.setId(this.key.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return this.posts.get(id);
    }


    public Collection<String> findAllComment(int id) {
       return this.findById(id).getDiscussion();
    }

    public void addComment(int id, String comment) {
        this.findById(id).getDiscussion().add(comment);
    }
}
