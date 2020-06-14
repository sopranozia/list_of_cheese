package org.launchcode.Hellospring.controller;


import org.launchcode.Hellospring.model.Cheese;
import org.launchcode.Hellospring.model.CheeseData;
import org.launchcode.Hellospring.model.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="cheese")
public class CheeseController {




    @RequestMapping(value = "")

    public String index(Model model) {

        model.addAttribute("title", "My Cheese list");
        model.addAttribute("cheeses", CheeseData.getAll());
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String DisplayAddCheeseForm(Model model) {

        model.addAttribute("title", "add cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes" , CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String ProcessAddCheeseForm(@ModelAttribute  @Valid Cheese newCheese, Errors errors, Model model) {

        if (errors.hasErrors()){

            model.addAttribute("title", "add cheese");

            return "cheese/add";

        }
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String DisplayRemoveCheeseForm(Model model) {

        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }


    @RequestMapping(value="remove", method = RequestMethod.POST)
    public String ProcessRemoveCheeseForm(@RequestParam int[] cheeseIds) {


        for(int cheeseId: cheeseIds){

            CheeseData.remove(cheeseId);
        }

        return "cheese/remove";
    }


}