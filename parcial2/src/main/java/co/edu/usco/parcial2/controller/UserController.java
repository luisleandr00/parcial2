package co.edu.usco.parcial2.controller;

import co.edu.usco.parcial2.entity.Vehiculos;
import co.edu.usco.parcial2.service.VehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    VehiculosService vehiculosService;
    @GetMapping("/vehiculos/list")
    public String showSubjectList(Model model) {

        List<Vehiculos> vehiculos = vehiculosService.findAll();

        model.addAttribute("vehiculos", vehiculos);
        return "vehiculosList";
    }

    @GetMapping("/loginPage")
    public String showLogin() {
        return "login";
    }
}


