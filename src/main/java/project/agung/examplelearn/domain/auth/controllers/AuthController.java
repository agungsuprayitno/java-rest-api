package project.agung.examplelearn.domain.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.agung.examplelearn.global.security.JwtService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping(path = "/token")
    public String getToken(@RequestBody Map<String, Object> claims) {
        return jwtService.generateJWT(claims);
    }

}
