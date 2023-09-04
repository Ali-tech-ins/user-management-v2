package com.tech.tech.Controller;

//import com.tech.tech.Exception.RequestException;
import com.tech.tech.Model.UserDTO;
import com.tech.tech.Model.UserMapper;
import com.tech.tech.Model.UserModel;

import com.tech.tech.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("helloWorld")
    String helloWorld () {
        //throw new RequestException("this is a custom exception!!");
        return "helloWorld!" ;
    }

    @PostMapping
    UserModel createUser(@RequestBody UserDTO newUserModel){
         UserModel user = userMapper.toEntity(newUserModel);
         return userRepo.save(user);
    }

    @GetMapping
    List<UserDTO> getUsers(){
        return userRepo.findAll()
                .stream()
                .map(user -> userMapper.toDTO(user) )

                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    Optional<UserDTO> getUserById(@PathVariable Long id){
        return userRepo.findById(id)
                .map(user -> userMapper.toDTO(user));


    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") Long id){
        boolean exists = userRepo.existsById(id);
        if(!exists){
            throw new IllegalStateException("there is no user with this id!");
        }
        userRepo.deleteById(id);
        return ("the "+ id +" user has been deleted successfully!");
    }

    @PutMapping("/{id}")
    Optional<UserModel> updateUser(@RequestBody UserModel newUser , @PathVariable Long id){
        return userRepo.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepo.save(user);
                });
    }


}
