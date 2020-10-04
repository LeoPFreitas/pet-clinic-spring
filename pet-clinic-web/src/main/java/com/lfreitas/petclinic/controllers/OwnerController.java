package com.lfreitas.petclinic.controllers;

import com.lfreitas.petclinic.model.Owner;
import com.lfreitas.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult bindingResult, Model model) {
        // allow parameterless GET request for /owners to return  possible research
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> result = ownerService.findAllByLastNameLikeIgnoreCase("%" + owner.getLastName() + "%");

        if (result.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (result.size() == 1) {
            owner = result.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", result);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(ownerService.findById(ownerId));
        return modelAndView;
    }

}
