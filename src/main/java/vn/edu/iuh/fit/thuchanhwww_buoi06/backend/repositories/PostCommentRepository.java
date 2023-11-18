package vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.PostComment;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findAllByPostId(Long postId);
}