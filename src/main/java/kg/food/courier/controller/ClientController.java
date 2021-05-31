package kg.food.courier.controller;

import kg.food.courier.entity.Organization;
import kg.food.courier.entity.User;
import kg.food.courier.enums.StatusList;
import kg.food.courier.model.ClientModel;
import kg.food.courier.model.ClientShortModel;
import kg.food.courier.service.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("{id}")
    public String getClientById(@PathVariable("id") Long id, Model model){
        User clientModel = userService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("status", StatusList.values());
        model.addAttribute("client",clientModel);
        return "clientForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            userService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, Model model, @ModelAttribute("client") User user, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(user);
        }
        user.setId(id);
        userService.update(user);
        return "redirect:/client/list";
    }

    @GetMapping("/form")
    public String getClientForm(Model model) {
        User user = new User();
        model.addAttribute("client",user);
        model.addAttribute("status", StatusList.values());
        model.addAttribute("add",true);
        return "clientForm";
    }

    @PostMapping(value = "/create")
    public String createClient(@ModelAttribute("client") User user,
                               BindingResult result, Model model) {
        /*if (result.hasErrors()) {
            model.addAttribute(organizationModelImage);
            model.addAttribute("add", true);
            return "organizationForm";
        }*/
        userService.create(user);
        return "redirect:/client/list";
    }




}
