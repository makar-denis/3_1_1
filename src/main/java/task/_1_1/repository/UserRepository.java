package task._1_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task._1_1.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
