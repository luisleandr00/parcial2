package co.edu.usco.parcial2.controller;

import co.edu.usco.parcial2.entity.Tipos;
import co.edu.usco.parcial2.entity.Vehiculos;
import co.edu.usco.parcial2.repository.VehiculosRepo;
import co.edu.usco.parcial2.service.VehiculosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class AdminContoller {
    @Autowired
    VehiculosService vehiculosService;

    @GetMapping("/add")
    public String addSubject(Model model) {

        Vehiculos newVeh = new Vehiculos();
        newVeh.setTipos(new Tipos());

        model.addAttribute("newVeh", newVeh);
        model.addAttribute("valor", "Añadir");

        return "modifyVehiculosForm";
    }
    @PostMapping("/insert")
    public String insertSubject(@Valid @ModelAttribute("newVeh") Vehiculos vehiculos, Errors error, Model model) {

        if (error.hasErrors()) {
            if (vehiculos.getId() == null) {
                model.addAttribute("valor", "Añadir");
            } else {
                model.addAttribute("valor", "Modificar");
            }
            return "modifyVehiculosForm";
        } else {
            vehiculosService.save(vehiculos);

            return "redirect:/vehiculos/list";
        }
    }
    @GetMapping("/modify/{id}")
    public String modifyOwner(@PathVariable Long id, Model model) {

        Vehiculos modVehiculos = vehiculosService.findById(id).orElse(null);

        model.addAttribute("newVeh", modVehiculos);
        model.addAttribute("valor", "Modificar");
        return "modifyVehiculosForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {

        vehiculosService.delete(id);

        return "redirect:/vehiculos/list";
    }
}
