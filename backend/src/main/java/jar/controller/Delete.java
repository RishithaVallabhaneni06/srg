package jar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.UserRepo;

@RestController
public class Delete {

    @Autowired
    UserRepo db;

    // DELETE request to remove a user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (db.existsById(id)) {
            db.deleteById(id);
            return "User with ID " + id + " deleted successfully.";
        } else {
            return "User with ID " + id + " not found.";
        }
    }
}
