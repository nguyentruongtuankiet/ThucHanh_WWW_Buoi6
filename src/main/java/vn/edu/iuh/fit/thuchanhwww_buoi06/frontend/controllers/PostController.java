package vn.edu.iuh.fit.thuchanhwww_buoi06.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.Post;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.PostComment;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.User;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.PostRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services.PostCommentServices;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services.PostServices;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//addpost
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostServices postServices;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String showProductListPaging(
            HttpSession session,
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);
        Page<Post> postPage = postServices.findPaginated(currentPage - 1,
                pageSize, "title", "asc");
        model.addAttribute("postPage", postPage);
        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "users/blog";
    }

    @GetMapping("/showaddpost")
    public String showaddPost() {
        return "users/addpost";
    }

    @PostMapping("/addpost")
    public String addPost(Model model, @RequestParam("title") String title, @RequestParam("summary") String summary, @RequestParam("content") String content, @RequestParam("published") Boolean published,HttpSession session) {
        Post post = new Post();
        post.setAuthor((User) session.getAttribute("useronl"));
        post.setContent(content);
        post.setCreatedAt(Instant.now());
        post.setMetaTitle("Meta Title for "+((User) session.getAttribute("useronl")).getFirstName());
        post.setPublished(published);
        post.setPublishedAt(Instant.now());
        post.setSummary(summary);
        post.setTitle(title);
        post.setPublishedAt(Instant.now());
        post.setPostComments(new LinkedHashSet<>());
        postRepository.save(post);

        return "redirect:/post/blog";
    }
}
