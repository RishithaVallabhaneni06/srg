package jar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jar.dto.UserData;
import jar.model.User;
import jar.repo.UserRepo;

@RestController
@CrossOrigin("*")
public class Signup {

    @Autowired
    UserRepo db;

    @PostMapping("/signup")
    public ResponseEntity<?> m1(@RequestBody UserData request) {

        User d = new User();
        d.setName(request.getName());
        d.setEmail(request.getEmail());
        d.setPassword(request.getPassword());

        db.save(d);
        return ResponseEntity.ok(Map.of("message", "User created successfully"));
    }

}
