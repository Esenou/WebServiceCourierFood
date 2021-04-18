package kg.food.courier.service.impl;

import kg.food.courier.entity.BaseEntity;
import kg.food.courier.entity.User;
import kg.food.courier.repository.UserRepository;
import kg.food.courier.service.UserService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }
}
