package com.atmim.demo.services.implement;

import com.atmim.demo.entities.UserInfo;
import com.atmim.demo.repositories.UserInfoRepository;
import com.atmim.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CommonServiceImpl<UserInfo, Integer> implements UserService {
    @Autowired
    public UserServiceImpl(UserInfoRepository repository) {
        super(repository);
    }
}
