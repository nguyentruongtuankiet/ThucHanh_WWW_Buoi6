package vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.Post;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.PostRepository;

import java.util.List;

@Service
public class PostServices {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(long postId) {
        return postRepository.findById(postId).orElse(null);
    }
    public Page<Post> findPaginated(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return postRepository.findAll(pageable);
    }
}