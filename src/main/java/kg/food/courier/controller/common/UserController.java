package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.User;
import kg.food.courier.service.UserService;
import kg.food.courier.service.base.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController< User, UserService> {


    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }
}
