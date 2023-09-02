package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.WithdrawalNoticeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The type Withdrawal notice controller.
 */
@RestController
@RequestMapping("/withdrawals")
public class WithdrawalNoticeController {
    @Autowired
    private WithdrawalNoticeServices withdrawalNoticeServices;

    /**
     * Create withdrawal notice withdrawal notice dto.
     *
     * @param withdrawalNoticeDTO the withdrawal notice dto
     * @return the withdrawal notice dto
     */
    @PostMapping("/create")
    public WithdrawalNoticeDTO createWithdrawalNotice(@RequestBody WithdrawalNoticeDTO withdrawalNoticeDTO){
        return withdrawalNoticeServices.createWithdrawalNotice(withdrawalNoticeDTO);
    }

    /**
     * Update withdrawal notice withdrawal notice dto.
     *
     * @param withdrawalNoticeDTO the withdrawal notice dto
     * @return the withdrawal notice dto
     */
    @PutMapping("/update")
    public WithdrawalNoticeDTO updateWithdrawalNotice(@RequestBody WithdrawalNoticeDTO withdrawalNoticeDTO){
        return withdrawalNoticeServices.updateWithdrawalNotice(withdrawalNoticeDTO).toDTO();
    }

    /**
     * Get withdrawal notice by id withdrawal notice dto.
     *
     * @param id the id
     * @return the withdrawal notice dto
     */
    @GetMapping("/get/{id}")
    public WithdrawalNoticeDTO getWithdrawalNoticeById(@PathVariable UUID id){
        return withdrawalNoticeServices.getWithdrawalNoticeById(id).toDTO();
    }

    /**
     * Delete withdrawal notice boolean.
     *
     * @param id the id
     * @return the boolean
     */
    @DeleteMapping("/delete/{id}")
    public boolean deleteWithdrawalNotice(@PathVariable UUID id){
        return withdrawalNoticeServices.deleteWithdrawalNotice(id);
    }
}
