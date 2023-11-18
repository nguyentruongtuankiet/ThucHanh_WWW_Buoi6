package vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.User;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.repositories.UserRepository;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean check(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user != null) {

            return user.getPasswordHash().equals(password);
        }

        return false;
    }

}