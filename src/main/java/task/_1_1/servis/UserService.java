package task._1_1.servis;

import task._1_1.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(long id);
    void change(User user);
    User getUser(long id);
    List<User> all();
}
