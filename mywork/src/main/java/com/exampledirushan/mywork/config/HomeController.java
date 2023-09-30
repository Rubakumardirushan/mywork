package com.exampledirushan.mywork.config;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;



@Controller
public class HomeController {

    @GetMapping("/")
    public String hom() {
        return "Hello, Home!";
    }

 @GetMapping("/secured")
public String securedHome(@AuthenticationPrincipal OAuth2User user, Model model) {
    if (user != null) {
        String username = user.getName(); // GitHub username
        String email = user.getAttribute("name"); // GitHub user's email
        // Add more attributes as needed from the GitHub user object
        model.addAttribute("username", username);
        model.addAttribute("email", email);
    } else {
        // Handle the case where user is null, possibly by redirecting to an error page or login page.
        return "redirect:/login";
    }

    return "home"; // Return the view name
}



}
