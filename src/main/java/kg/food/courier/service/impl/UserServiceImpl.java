package kg.food.courier.service.impl;


import kg.food.courier.entity.User;
import kg.food.courier.model.ClientShortModel;
import kg.food.courier.repository.UserRepository;
import kg.food.courier.service.UserService;
import kg.food.courier.service.base.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository> implements UserService{

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findByUsernameWithSearch(Pageable pageable, String value) {
        return userRepository.findByUsernameWithSearch(pageable,value);
    }

    @Override
    public Page<User> getAllByPageable(Pageable pageable) {
        return userRepository.getAllByPageable(pageable);
    }


}
