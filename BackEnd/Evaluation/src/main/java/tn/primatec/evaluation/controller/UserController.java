package tn.primatec.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.primatec.evaluation.model.Employee;
import tn.primatec.evaluation.model.user.User;
import tn.primatec.evaluation.service.UserService;

import static tn.primatec.evaluation.application.ApplicationProperties.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("{userId}/employees")
    public ResponseEntity<?> addEmployee(@PathVariable long userId, @RequestBody Employee employee) {
        return userService.addEmployee(userId, employee);
    }
}
