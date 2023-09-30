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
public String securedHome(@AuthenticationPrincipal OAuth2User user, Model model) {
    if (user != null) {
        String username = user.getAttribute("login"); // GitHub username
        String email = user.getAttribute("email"); // GitHub user's email
        String location = user.getAttribute("location"); 
        if(email==null){
            email="email is private";
        }
        if(username==null){
            username=user.getAttribute("name"); 
        }
        // Add more attributes as needed from the GitHub user object
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        model.addAttribute("location", location);
    
    } else {
        // Handle the case where user is null, possibly by redirecting to an error page or login page.
        return "redirect:/login";
    }

    return "home"; // Return the view name
}



}
