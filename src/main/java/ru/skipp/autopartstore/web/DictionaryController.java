package ru.skipp.autopartstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.skipp.autopartstore.services.CarService;
import ru.skipp.autopartstore.services.ClientsService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private CarService carService;
    @Autowired
    private ClientsService clientsService;

    @GetMapping("/cars")
    public String GetCars(Model model){
        model.addAttribute("cars", carService.findAll());
        return "carList";
    }
}
