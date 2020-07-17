package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class ApplicationSpring {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationSpring.class, args);
    }

//    @RequestMapping(value = "/user")
//    public Principal user(Principal principal) {
//        return principal;
//    }

}
