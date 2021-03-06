package task._1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import task._1_1.models.User;
import task._1_1.servis.UserService;

import javax.annotation.PostConstruct;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//
    @GetMapping("/users")
    public String allUser( ModelMap model) {
        model.addAttribute("listUsers", userService.all());
        return "user";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }

    @PostMapping("/create")
    public String createUser(User user){
        userService.add(user);
        return "redirect:users";
    }

    @DeleteMapping("/delete")
    public String deleteUser( @RequestParam(value="id") long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, ModelMap model){
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PutMapping("/update")
    public String updateUser(User user){
        userService.change(user);
        return "redirect:users";
    }

    @PostConstruct
    public void init() {
        userService.add(new User( "Denis", "Markachev", "@1"));
        userService.add(new User("Dima", "Markachev", "@2"));
        userService.add(new User("Julia", "Markacheva", "@3"));
    }

}
