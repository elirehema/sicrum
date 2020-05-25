package com.webhook.springrestfull.authorization.repository;

import com.webhook.springrestfull.authorization.data.UserData;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData, Integer> { }
