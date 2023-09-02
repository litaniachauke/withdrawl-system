package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/investor")
public class InvestorController {
    @Autowired
    private InvestorService investorService;
    @PostMapping("/create")
    public InvestorDTO createInvestor(@RequestBody InvestorDTO investorDTO){
        return investorService.createInvestor(investorDTO);
    }
    @PutMapping("/update")
    public InvestorDTO updateInvestor(@RequestBody InvestorDTO investorDTO){
        return investorService.updateInvestor(investorDTO);
    }
    @GetMapping("/get/{id}")
    public InvestorDTO getInvestorById(@PathVariable UUID id){
        return investorService.getInvestorById(id);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteInvestor(@PathVariable UUID id){
        return investorService.deleteInvestor(id);
    }
    @GetMapping("/withdraw/{productId}/{amount}")
    public boolean makeWithdrawal(@PathVariable UUID productId,@PathVariable double amount){
        return investorService.makeWithdrawal(productId, amount);
    }
}
