package com.webhook.springrestfull.authorization.services;

import com.webhook.springrestfull.authorization.data.UserData;
import com.webhook.springrestfull.authorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersReadAndWriteJpaServiceImpl implements UsersReadAndWriteJpaService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserData persistNewUserInfos(UserData userData) {
        UserData _userData = userRepository.save(userData);
        return _userData;
    }

    @Override
    public HttpStatus deleteUserById(int _userId) {
        userRepository.deleteById(_userId);
        return HttpStatus.NO_CONTENT;
    }

    @Override
    public Optional<UserData> getUserById(Integer _ids) {
        return userRepository.findById(_ids);
    }

    @Override
    public UserData editUser(Integer _id, UserData requestUserData) {
        Optional<UserData> _userData = userRepository.findById(_id);

        if (_userData.isPresent()) {
            UserData dUserData = _userData.get();
            dUserData.setEmail(requestUserData.getEmail() != null ? requestUserData.getEmail() : dUserData.getEmail());
            dUserData.setName(requestUserData.getName() != null ? requestUserData.getName() : dUserData.getName());
            dUserData.setPhone(requestUserData.getPhone() != null ? requestUserData.getPhone() : dUserData.getPhone());
            dUserData.setDob(requestUserData.getDob() !=null ? requestUserData.getDob(): dUserData.getDob());
            userRepository.save(dUserData);
            return dUserData;
        } else {
            return requestUserData;
        }
    }


}
