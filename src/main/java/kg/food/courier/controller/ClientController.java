package kg.food.courier.controller;

import kg.food.courier.entity.Client;
import kg.food.courier.enums.StatusList;
import kg.food.courier.service.ClientService;

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

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/list")
    public String getClientList(@PageableDefault Pageable pageable,
                                @RequestParam(value = "search", required = false) String value, Model model){
        Page<Client> clients;
        if(value != null){
            clients = clientService.findByUsernameWithSearch(pageable,value);
        } else {
            clients = clientService.getAllByPageable(pageable);
        }
        model.addAttribute("clients",clients);
        return "clientList";
    }

    @GetMapping("{id}")
    public String getClientById(@PathVariable("id") Long id, Model model){
        Client clientModel = clientService.findById(id);
        model.addAttribute("add",false);
        model.addAttribute("status", StatusList.values());
        model.addAttribute("client",clientModel);
        return "clientForm";
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        try {
            clientService.deleteById(id);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("has_exception", true);
            return "redirect:/client/" + id;
        }
        return "redirect:/client/list";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") Long id, Model model, @ModelAttribute("client") Client user, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("add", false);
            model.addAttribute(user);
        }
        user.setId(id);
        clientService.update(user);
        return "redirect:/client/list";
    }




}
