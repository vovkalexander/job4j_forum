package ru.job4j.forum.model;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "description")
    private String desc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    @ElementCollection
    @CollectionTable (
            name = "discussion",
            joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "discussion")
    private Set<String> discussion = new HashSet<>();

    public Post() {
    }

    public static Post of(int id, String name, String desc, LocalDate date) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.desc = desc;
        post.created = date;
        return post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

      public Set<String> getDiscussion() {
          return discussion;
     }

      public void setDiscussion(Set<String> discussion) {
         this.discussion = discussion;
      }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(name, post.name) &&
                Objects.equals(desc, post.desc) &&
                Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }

    private Calendar parseCalendar(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd", Locale.forLanguageTag("en"));
        cal.setTime((sdf).parse(date));
        return cal;
    }
}


