package ru.job4j.forum.control;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import static org.mockito.Mockito.verify;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc

public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService posts;

    @Test
    @WithMockUser
    public void shouldReturnPostPage() throws Exception {
        this.mockMvc.perform(get("/post").param("id", "8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnPostForm() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnEditPage() throws Exception {
        this.mockMvc.perform(get("/edit").param("id", "8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    @WithMockUser
    public void shouldReturnCommentPage() throws Exception {
        this.mockMvc.perform(get("/comment").param("id", "8"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("comment"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/save")
                        .param("name","Ныряние в клетке с акулами"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/index"));
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).addPost(argument.capture());
        assertThat(argument.getValue().getName(), is("Ныряние в клетке с акулами"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultComment() throws Exception {
        String comment = "Какую брать приманку";
        this.mockMvc.perform(post("/add")
                        .param("id", "8")
                        .param("comment", comment))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post?id=8"));
        verify(posts).addComment(8,  comment);
    }
}
