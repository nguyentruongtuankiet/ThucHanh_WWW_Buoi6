package vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.Post;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.PostComment;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.PostCommentRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.PostRepository;

import java.util.List;

@Service
public class PostCommentServices {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<PostComment> findAllByPostId(Long postId){
        return postCommentRepository.findAllByPostId(postId);
    }

}
