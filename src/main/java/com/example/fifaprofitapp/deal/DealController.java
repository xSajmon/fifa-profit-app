package com.example.fifaprofitapp.deal;


import com.example.fifaprofitapp.card.CardType;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/deals")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public String showDeals(Model model, @RequestParam Optional<String> surname){

        List<Deal> list = dealService.getDeals(surname);
        double totalProfit = dealService.calculateTotalProfit(list);
        Deal deal = Optional.ofNullable((Deal)model.getAttribute("deal")).orElse(new Deal());
        model.addAttribute("deal", deal);
        model.addAttribute("deals", list);
        model.addAttribute("sum", totalProfit);
        model.addAttribute("num", list.size());
        return "deals";
    }

    @PostMapping
    public String saveDeal(@ModelAttribute("deal") @Valid Deal deal,
                           BindingResult result,
                           RedirectAttributes redirectAttributes,
                           Model model) {

        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("deal", deal);
            return "redirect:/deals";
        }
        dealService.saveDeal(deal);
        model.addAttribute("deal", new Deal());
        return "redirect:/deals";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDeal(@PathVariable Long id){
        dealService.deleteDeal(id);
        return "redirect:/deals";
    }

    @PutMapping("/update/{id}")
    public String updateDeal(@PathVariable Long id, @RequestBody Deal deal){
        Deal toUpdate = dealService.findDealById(id);
        BeanUtils.copyProperties(deal, toUpdate, "id", "saleDate");
        dealService.saveDeal(toUpdate);
        return "redirect:/deals";
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
