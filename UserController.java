package com.FeedbackSurvey.SpringBoot.project.Controller;
import com.FeedbackSurvey.SpringBoot.project.entity.EUser;
import com.FeedbackSurvey.SpringBoot.project.operation.UserOperation;
import com.FeedbackSurvey.SpringBoot.project.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserOperation userOperation;

    public UserController(UserRepository userRepository) {
        this.userOperation = userOperation;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User user) {
        String id = userOperation.create(user);
        return ResponseEntity.created(URI.create(id)).build();
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<EUser> getUserById(@PathVariable("userId") String userId) {
        return userOperation.getById(userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody User userDetails) {
        userOperation.update(id, userDetails);
        return ResponseEntity.noContent().build();
    }
}


