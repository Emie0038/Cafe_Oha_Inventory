package com.example.cafebackend.Controller;

import com.example.cafebackend.Entity.User;
import com.example.cafebackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<String> editUser(@PathVariable("id") Long id, @RequestBody User user){
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<>("user edited", HttpStatus.OK);
    }
}
