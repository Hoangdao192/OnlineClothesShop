package personal.project.onlineclothesshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import personal.project.onlineclothesshop.user.UserModel;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path = "/login")
    public String login(
            @RequestParam(value = "error", defaultValue = "false") boolean loginError,
            Model model, RedirectAttributes redirectAttributes)
    {
        if (loginError) {
            model.addAttribute("error", "Username or password is incorrect.");
            redirectAttributes.addFlashAttribute("error", "Username or password is incorrect.");
            return "redirect:/login";
        }
        return "login";
    }

    @PostMapping(path = "/login")
    public String authentication(UserModel userModel) {
        System.out.println("Authenticating");
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userModel.getUsername(), userModel.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            return "redirect:/login";
        }
        return "home";
    }

}
