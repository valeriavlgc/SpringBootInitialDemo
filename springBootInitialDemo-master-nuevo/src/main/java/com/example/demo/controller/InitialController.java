package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/")
public class InitialController {

    private final IUserService userService;

    @Autowired
    public InitialController(IUserService userService){
        this.userService = userService;
    }

    
    @GetMapping("/GET/{name}")
    public String helloWorld(@PathVariable String name) {
        return "Hello " + name;
    }
    
    @PostMapping("/POST")
    public String helloWorld2() {
        return "This is a post";
    }
    
    @DeleteMapping("/DELETE")
    public String helloWorld3() {
        return "This is a delete";
    }
    
    @PutMapping("/PUT")
    public String helloWorld4() {
        return "This is a put";
    } 

    //@PutMapping(value ="", consumes = {"application/json"})
    @GetMapping("/user/{uuid}")
    public ResponseEntity<UserResponseDto> updatePrescription(
            @PathVariable(name="uuid") String user) throws Exception {


        UserResponseDto userResponseDto = userService.getUser("pp");

        System.out.println(userResponseDto.getName());
        System.out.println(userResponseDto.getSurname());
        System.out.println(userResponseDto.getGender());

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);

    }


}
