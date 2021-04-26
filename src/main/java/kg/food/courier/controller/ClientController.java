package kg.food.courier.controller;

import kg.food.courier.entity.User;
import kg.food.courier.model.ClientShortModel;
import kg.food.courier.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("client")
public class ClientController {

    private final UserService userService;

    public ClientController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getClientList(@PageableDefault Pageable pageable,
                                @RequestParam(value = "search", required = false) String value, Model model){
        Page<User> clients;
        if(value != null){
            clients = userService.findByUsernameWithSearch(pageable,value);
        } else {
            clients = userService.getAllByPageable(pageable);
        }
        model.addAttribute("clients",clients);
        return "clientList";
    }



}
