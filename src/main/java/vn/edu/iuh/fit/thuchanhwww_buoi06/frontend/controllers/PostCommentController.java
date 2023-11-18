package vn.edu.iuh.fit.thuchanhwww_buoi06.frontend.controllers;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.Post;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.PostComment;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.User;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services.PostServices;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("/postcomment")
public class PostCommentController {
    @Autowired
    private PostCommentRepository postCommentRepository;
    @Autowired
    private PostServices postServices;

    @GetMapping("/show-one-post/{id}")
    public String showPostComment(@PathVariable("id") Long postId, Model model,HttpSession session) {
        List<PostComment> postCommentList = postCommentRepository.findAllByPostId(postId);
        for (PostComment postcm: postCommentList) {
            System.out.println(postcm.getPublished());
        }
        Post post = postServices.getPostById(postId);
        model.addAttribute("post", post);
        model.addAttribute("postCommentList", postCommentList);
        User user =  (User) session.getAttribute("useronl");
        model.addAttribute("useronl",user);
        return "users/postcomment";
    }
    @PostMapping("/addpostcomment")
    public String addPostComment(Model model , @RequestParam("id")Long id,@RequestParam("comment") String comment,HttpSession session) {


        PostComment postComment = new PostComment();
        postComment.setContent(comment);
        postComment.setCreatedAt(Instant.now());
        postComment.setPostComments(new LinkedHashSet<>());
        postComment.setPublished(true);
        postComment.setUser((User) session.getAttribute("useronl"));
        postComment.setPost(postServices.getPostById(id));
        postComment.setTitle("Comment of"+(User)model.getAttribute("useronl"));
        postComment.setPublishedAt(Instant.now());
        postCommentRepository.save(postComment);

        List<PostComment> postCommentList = postCommentRepository.findAllByPostId(id);
        Post post = postServices.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("postCommentList", postCommentList);
        User user =  (User) session.getAttribute("useronl");
        model.addAttribute("useronl",user);
        return "users/postcomment";
    }
}
