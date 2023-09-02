package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.InvestorDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The type Investor controller.
 */
@RestController
@RequestMapping("/investor")
public class InvestorController {
    @Autowired
    private InvestorService investorService;

    /**
     * Create investor investor dto.
     *
     * @param investorDTO the investor dto
     * @return the investor dto
     */
    @PostMapping("/create")
    public InvestorDTO createInvestor(@RequestBody InvestorDTO investorDTO){
        return investorService.createInvestor(investorDTO);
    }

    /**
     * Update investor investor dto.
     *
     * @param investorDTO the investor dto
     * @return the investor dto
     */
    @PutMapping("/update")
    public InvestorDTO updateInvestor(@RequestBody InvestorDTO investorDTO){
        return investorService.updateInvestor(investorDTO);
    }

    /**
     * Get investor by id investor dto.
     *
     * @param id the id
     * @return the investor dto
     */
    @GetMapping("/get/{id}")
    public InvestorDTO getInvestorById(@PathVariable UUID id){
        return investorService.getInvestorById(id);
    }

    /**
     * Delete investor boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/delete/{id}")
    public boolean deleteInvestor(@PathVariable UUID id){
        return investorService.deleteInvestor(id);
    }

    /**
     * Make withdrawal boolean.
     *
     * @param productId the product id
     * @param amount    the amount
     * @return the boolean
     */
    @GetMapping("/withdraw/{productId}/{amount}")
    public boolean makeWithdrawal(@PathVariable UUID productId,@PathVariable double amount){
        return investorService.makeWithdrawal(productId, amount);
    }
}
