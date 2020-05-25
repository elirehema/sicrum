package com.webhook.springrestfull.users;

import com.webhook.springrestfull.authorization.data.UserData;
import com.webhook.springrestfull.authorization.repository.UserRepository;
import com.webhook.springrestfull.authorization.services.UsersReadAndWriteJpaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2RestController {
    @Autowired
    UsersReadAndWriteJpaServiceImpl usersReadAndWriteJpaRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserData>> listAllUsers(){
        try {
            Iterable<UserData> _iterableUserData = userRepository.findAll();
            return new ResponseEntity<>(_iterableUserData, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

}
