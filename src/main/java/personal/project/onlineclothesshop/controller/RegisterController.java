package personal.project.onlineclothesshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import personal.project.onlineclothesshop.user.UserEntity;
import personal.project.onlineclothesshop.user.UserInformationRepository;
import personal.project.onlineclothesshop.user.UserRegisterModel;
import personal.project.onlineclothesshop.user.UserRepository;

import java.util.Optional;

@Controller
public class RegisterController {
    private UserRepository userRepository;
    private UserInformationRepository userInformationRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping(path = "/register")
    public String register(RedirectAttributes redirectAttributes) {
        return "register";
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String submitRegister(UserRegisterModel userModel, Model model,
                                 RedirectAttributes redirectAttributes)
    {
        if (userRepository.existsByUsername(userModel.getUsername())) {
            redirectAttributes.addFlashAttribute(
                    "usernameError", "Username exists.");
            return "redirect:/register";
        }

        if (userInformationRepository.existsByEmail(userModel.getEmail())) {
            redirectAttributes.addFlashAttribute(
                    "emailError", "Email had been use by another account.");
            return "redirect:/register";
        }

        UserEntity user = new UserEntity();
        user.setUsername(userModel.getUsername());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return "redirect:/home";
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserInformationRepository(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }
}
