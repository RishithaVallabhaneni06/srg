package jar.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jar.repo.UserRepo;
import jar.dto.U;
import jar.model.User;

import java.util.Optional;

@Service
public class Authentication {

    @Autowired
    UserRepo db;

    public String updateUser(Long id, U u) {
        Optional<User> data = db.findById(id);
        if (data.isEmpty()) {
            return "User not found";
        }
        User user = data.get();
        user.setName(u.getName());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        db.save(user);
        return " user updated sucees ✅";
    }
}
