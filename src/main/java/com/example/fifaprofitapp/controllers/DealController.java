package com.example.fifaprofitapp.controllers;


import com.example.fifaprofitapp.domain.Card;
import com.example.fifaprofitapp.domain.CardType;
import com.example.fifaprofitapp.domain.Deal;
import com.example.fifaprofitapp.services.DealService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/deals/index")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public String showDeals(Model model, @RequestParam Optional<String> surname){

        List<Deal> list = dealService.getDeals(surname);
        double totalProfit = dealService.calculateTotalProfit(list);

        model.addAttribute("deal", new Deal());
        model.addAttribute("dealToUpdate", new Deal());
        model.addAttribute("deals", list);
        model.addAttribute("sum", totalProfit);
        model.addAttribute("num", list.size());

        return "deals/index";
    }

    @PostMapping
    public String saveDeal(@ModelAttribute("deal") @Valid Deal deal,
                           BindingResult result,
                           Model model) {
        dealService.saveDeal(deal);
        model.addAttribute("deal", new Deal());
        return "redirect:/deals/index";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeal(@PathVariable Long id){
        dealService.deleteDeal(id);
        return "redirect:/deals/index";
    }

    @PutMapping("/update/{id}")
    public String updateDeal(@PathVariable Long id, @RequestBody Deal deal){
        Deal toUpdate = dealService.findDealById(id);
        BeanUtils.copyProperties(deal, toUpdate, "id", "saleDate");
        dealService.saveDeal(toUpdate);
        return "redirect:/deals/index";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Deal findDealById(@PathVariable Long id){
        return dealService.findDealById(id);
    }

    @ModelAttribute("allCardTypes")
    public List<String> getTypes(){
        return Stream.of(CardType.values()).map(CardType::name).collect(Collectors.toList());
    }



}
