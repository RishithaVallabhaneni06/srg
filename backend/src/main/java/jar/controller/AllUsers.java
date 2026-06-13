package jar.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.User;
import jar.repo.UserRepo;

@RestController
public class AllUsers {

    @Autowired
    UserRepo db;

    @GetMapping("/all")
    public List<User> m1() {
        return db.findAll();
    }

}
