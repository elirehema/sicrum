package com.webhook.springrestfull;

import com.webhook.springrestfull.authorization.data.UserData;
import com.webhook.springrestfull.authorization.repository.UserRepository;
import com.webhook.springrestfull.authorization.services.UsersReadAndWriteJpaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UsersReadAndWriteJpaServiceImpl usersReadAndWriteJpaRepository;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public ResponseEntity<UserData> addNewUser(@Valid @RequestBody UserData userData) {
        try {
            UserData _savedUserData = usersReadAndWriteJpaRepository.persistNewUserInfos(userData);
            return new ResponseEntity<>(_savedUserData, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserData>> getAllUser() {
        try {
            Iterable<UserData> _iterableUserData = userRepository.findAll();
            return new ResponseEntity<>(_iterableUserData, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserData> retrieveUserByUserId(@PathVariable("id") int _id) {
        try {
            Optional<UserData> ud = usersReadAndWriteJpaRepository.getUserById(_id);

            return new ResponseEntity<UserData>(ud.get(), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(path = "users/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<UserData> editUserInfos(@PathVariable("id") int _userId, @Valid @RequestBody UserData _requestUserDatas) {
        try {
            UserData _updatedUserData = usersReadAndWriteJpaRepository.editUser(_userId, _requestUserDatas);
            return new ResponseEntity<>(_updatedUserData, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


    @DeleteMapping(path = "users/{id}")
    public ResponseEntity<HttpStatus> deleteUserbyUserId(@PathVariable("id") int userId) {
        try {
            usersReadAndWriteJpaRepository.deleteUserById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}
