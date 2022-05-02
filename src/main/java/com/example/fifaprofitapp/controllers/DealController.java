package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/deals/add")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping("/deals/json")
    @ResponseBody
    public Collection<Deal> getDealsJson() {
        return dealService.getDeals();
    }

    @GetMapping
    public String addDeal(Model model, String surname) {
        model.addAttribute("deal", new Deal());
        Optional<String> opt = Optional.ofNullable(surname);
        if(opt.isPresent()){
            model.addAttribute("deals", dealService.findAllByPlayer(surname));
            model.addAttribute("sum", dealService.calculateTotalProfit(surname));
            model.addAttribute("num", dealService.findAllByPlayer(surname).size());
        }else{
            model.addAttribute("deals", dealService.getDeals());
            model.addAttribute("sum", dealService.calculateTotalProfit());
            model.addAttribute("num", dealService.getDeals().size());
        }

        return "deals/add";
    }


    @PostMapping
    public String saveDeal(@Valid @ModelAttribute("deal") Deal deal,
                           BindingResult result,
                           HttpServletRequest request) {
        if (result.hasErrors()) {
            return "redirect:"+ request.getRequestURI();
        }
        dealService.saveDeal(deal);
        return "redirect:/deals/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeal(@PathVariable("id") Long id){
        dealService.deleteDeal(id);
        return "redirect:/deals/add";
    }



}
