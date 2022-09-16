package ru.skipp.autopartstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.skipp.autopartstore.model.Client;
import ru.skipp.autopartstore.services.ClientsService;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/dictionary/clients")
public class ClientController {

    @Autowired
    private ClientsService clientsService;

    @GetMapping
    public String getClients(Model model) {
        model.addAttribute("clients", clientsService.findAll());
        return "clientList";
    }

    @GetMapping("{client}")
    public String editClientForm(@PathVariable Client client, Model model){
        model.addAttribute("client", client);
        return "clientEdit";
    }

    @PostMapping
    public String clientSave(
//            @RequestParam Map<String, String> form,   в форме собираются все данные с HTML-формы
            @RequestParam("clientId") Client client,
            @Valid Client clientNew
    ){
        clientsService.saveClient(client, clientNew);
        return "redirect:/dictionary/clients";
    }

//    @PostMapping("{client}")
//    public String deleteClientByPost(@PathVariable Client client, Model mode){
//        clientsService.deleteClient(client);
//        return "redirect:/dictionary/clients";
//    }

    @DeleteMapping("{client}")
    public String deleteClient(@PathVariable Client client, Model mode){
        clientsService.deleteClient(client);
        return "redirect:/dictionary/clients";
    }
}
