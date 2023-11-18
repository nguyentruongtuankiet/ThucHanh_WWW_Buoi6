package vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}