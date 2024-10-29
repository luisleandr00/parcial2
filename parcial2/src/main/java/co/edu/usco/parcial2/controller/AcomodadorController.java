package co.edu.usco.parcial2.controller;

import co.edu.usco.parcial2.entity.Vehiculos;
import co.edu.usco.parcial2.service.VehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/")
public class AcomodadorController {
    @Autowired
    VehiculosService vehiculosService;
    @GetMapping("/vehiculos/list")
    public String showSubjectList(Model model) {

        List<Vehiculos> vehiculos = vehiculosService.findAll();

        model.addAttribute("vehiculos", vehiculos);
        return "vehiculosList";
    }
    @GetMapping("/modify/{id}")
    public String modifyOwner(@PathVariable Long id, Model model) {

        Vehiculos modVehiculos = vehiculosService.findById(id).orElse(null);

        model.addAttribute("newVeh", modVehiculos);
        model.addAttribute("valor", "Modificar");
        return "modifyVehiculosForm";
    }
}
