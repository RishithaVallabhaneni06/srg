package jar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jar.model.User;
import jar.repo.UserRepo;
import jar.services.JwtService;

@RestController
@RequestMapping("/auth")
public class Login {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User request) {

        User user = userRepo.findByEmail(request.getEmail()).orElse(null);

        if (user == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "User not found"));
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Invalid password"));
        }

        String token = jwtService.generateJwtToken(user);

        return ResponseEntity.ok(
                Map.of(
                        "message", "Login successful",
                        "token", token
                )
        );
    }
}