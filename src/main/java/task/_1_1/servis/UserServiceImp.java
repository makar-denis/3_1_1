package task._1_1.servis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task._1_1.models.User;
import task._1_1.repository.UserRepository;

import java.util.List;
@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;
    @Autowired
    public UserServiceImp (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void change(User user){
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> all() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.getById(id);
//        return userRepository.getOne(id);
//        return userRepository.getReferenceById(id);
    }




}
