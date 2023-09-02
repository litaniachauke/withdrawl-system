package com.enviro.assessment.grad001.withdrawlsystem.controllers.rest;

import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.WithdrawalNoticeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalNoticeController {
    @Autowired
    private WithdrawalNoticeServices withdrawalNoticeServices;
    @PostMapping("/create")
    public WithdrawalNoticeDTO createWithdrawalNotice(@RequestBody WithdrawalNoticeDTO withdrawalNoticeDTO){
        return withdrawalNoticeServices.createWithdrawalNotice(withdrawalNoticeDTO);
    }
    @PutMapping("/update")
    public WithdrawalNoticeDTO updateWithdrawalNotice(@RequestBody WithdrawalNoticeDTO withdrawalNoticeDTO){
        return withdrawalNoticeServices.updateWithdrawalNotice(withdrawalNoticeDTO).toDTO();
    }
    @GetMapping("/get/{id}")
    public WithdrawalNoticeDTO getWithdrawalNoticeById(@PathVariable UUID id){
        return withdrawalNoticeServices.getWithdrawalNoticeById(id).toDTO();
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteWithdrawalNotice(@PathVariable UUID id){
        return withdrawalNoticeServices.deleteWithdrawalNotice(id);
    }
}
