package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import umc.study.service.UserService.UserCommandService;
import umc.study.web.dto.UserRequestDTO;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserCommandService userCommandService;

    @PostMapping("/users/signup")
    public String signupUser(@ModelAttribute("userJoinDto") UserRequestDTO.SignupDto request,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        try {
            userCommandService.signupUser(request);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userSignupDto", new UserRequestDTO.SignupDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
