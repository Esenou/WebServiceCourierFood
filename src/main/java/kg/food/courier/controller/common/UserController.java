package kg.food.courier.controller.common;

import kg.food.courier.controller.base.BaseController;
import kg.food.courier.entity.Client;
import kg.food.courier.service.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController<Client, ClientService> {


    private final ClientService clientService;

    public UserController(ClientService clientService) {
        super(clientService);
        this.clientService = clientService;
    }
}
