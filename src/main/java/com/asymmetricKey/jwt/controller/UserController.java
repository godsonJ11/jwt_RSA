package com.asymmetricKey.jwt.controller;

import com.asymmetricKey.jwt.dto.UserDTO;
import com.asymmetricKey.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public String RegisterUser(@RequestBody UserDTO userDTO){
        return userService.storeUserDetails(userDTO);
    }
    @GetMapping("demo")
    public String demoApi(){
        return "hello api is working";
    }

}
