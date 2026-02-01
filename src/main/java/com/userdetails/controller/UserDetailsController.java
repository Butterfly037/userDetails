package com.userdetails.controller;

import com.userdetails.dto.UserDetailsDto;
import com.userdetails.service.UserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    //CREATE
    @PostMapping
    private ResponseEntity<UserDetailsDto> persistUserDetails(@RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailsService.createUser(userDetailsDto));
    }


    //UPDATE
    @PutMapping("/{id}")
    private ResponseEntity<UserDetailsDto> updateUserDetails(@PathVariable Long id, @RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailsService.updateUser(id,userDetailsDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsDto> getUserDetailsDto(@PathVariable Long id) {
        return ResponseEntity.ok(userDetailsService.retriveUserDetailsById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userDetailsService.deleteUserUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/AllUsers")
    private ResponseEntity<List<UserDetailsDto>> getAllUserDetailsDto(){
        return ResponseEntity.ok(userDetailsService.getUserDetails());
    }

    /**
     * use this link to connect database
     * and change database url like used in application properties, user name and password
     * http://localhost:8080/h2-console/login.jsp?jsessionid=5eb8514537382c3da0368094656e6257
     */
}
