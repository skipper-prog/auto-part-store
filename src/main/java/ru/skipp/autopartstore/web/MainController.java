package ru.skipp.autopartstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.skipp.autopartstore.model.Role;
import ru.skipp.autopartstore.model.User;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
//        model.put("user", new User("admin@tp.ru", "admin", "", "1", new HashSet<Role>(Arrays.asList(Role.ADMIN))));
        return "greeting";
    }
}
