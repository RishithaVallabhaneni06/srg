package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jar.services.Authentication;
import jar.dto.U;
import jar.repo.UserRepo;

@RestController
public class Update {

    @Autowired
    Authentication s;

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody U u) {

        return " Response : " + s.updateUser(id, u); 
    }
}
