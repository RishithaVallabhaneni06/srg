package jar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import jar.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    
}
