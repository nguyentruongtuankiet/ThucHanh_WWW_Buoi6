package vn.edu.iuh.fit.thuchanhwww_buoi06.frontend.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.models.User;
import vn.edu.iuh.fit.thuchanhwww_buoi06.backend.services.UserServices;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @RequestMapping("/login")
    public String LoginForm() {
        return "users/login"; //
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        boolean check = userServices.check(username, password);
        User user = userServices.findByEmail(username);

        session.setAttribute("useronl",user);
        if (check) {
            return "redirect:/post/blog";
        } else {
            model.addAttribute("error", "Tài khoản không tồn tại");
            return "users/login";
        }
    }
}
