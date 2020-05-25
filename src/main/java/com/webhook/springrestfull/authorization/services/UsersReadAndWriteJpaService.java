package com.webhook.springrestfull.authorization.services;

import com.webhook.springrestfull.authorization.data.UserData;
import org.springframework.http.HttpStatus;

import java.util.Optional;

public interface UsersReadAndWriteJpaService {

    public UserData persistNewUserInfos(UserData userData);

    public HttpStatus deleteUserById(int _userId);

    public Optional<UserData> getUserById(Integer _id);

    public UserData editUser(Integer userid, UserData userData);

}
