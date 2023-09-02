package com.enviro.assessment.grad001.withdrawlsystem.services.serviceImplemetation;

import com.enviro.assessment.grad001.withdrawlsystem.Repository.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.withdrawlsystem.csvHandler.CsvHandler;
import com.enviro.assessment.grad001.withdrawlsystem.dto.WithdrawalNoticeDTO;
import com.enviro.assessment.grad001.withdrawlsystem.entities.Product;
import com.enviro.assessment.grad001.withdrawlsystem.entities.WithdrawalNotice;
import com.enviro.assessment.grad001.withdrawlsystem.services.serviceInterface.WithdrawalNoticeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * The type Withdrawal service notice implementation.
 */
@Service
public class WithdrawalServiceNoticeImplementation implements WithdrawalNoticeServices {
    @Autowired
    private WithdrawalNoticeRepository withdrawalNoticeRepository;
    @Autowired
    private final CsvHandler csvHandlerService = new CsvHandler();
    @Override
    public WithdrawalNoticeDTO createWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice) {
        if(withdrawalNotice != null){
            return withdrawalNoticeRepository.save(new WithdrawalNotice().fromDTO(withdrawalNotice)).toDTO();
        }else {
            throw new RuntimeException("Withdrawal Notice is null!");
        }
    }

    @Override
    public WithdrawalNotice updateWithdrawalNotice(WithdrawalNoticeDTO withdrawalNotice) {
        WithdrawalNotice withdrawalNotice1 = withdrawalNoticeRepository.findById(withdrawalNotice.id()).orElse(null);
        if(withdrawalNotice1 != null){
            withdrawalNoticeRepository.save(new WithdrawalNotice().fromDTO(withdrawalNotice));
            return withdrawalNotice1;
        }else {
            throw new RuntimeException("Withdrawal Notice not found!");
        }
    }

    @Override
    public boolean deleteWithdrawalNotice(UUID id) {
        if(withdrawalNoticeRepository.findById(id).isPresent()){
            withdrawalNoticeRepository.deleteById(id);
            return true;
        }else {
            throw new RuntimeException("Withdrawal Notice not found!");
        }
    }

    @Override
    public WithdrawalNotice getWithdrawalNoticeById(UUID id) {
        return withdrawalNoticeRepository.findById(id).orElseThrow(() -> new RuntimeException("Withdrawal Notice not found!"));
    }

    @Override
    public List<WithdrawalNotice> getWithdrawalNoticeByProduct(Product product) throws IOException {
        List<WithdrawalNotice> withdrawalNoticeList = withdrawalNoticeRepository.findByProduct(product);
        if(csvHandlerService.exportCsv(withdrawalNoticeList)) {
            return withdrawalNoticeList;
        }else {
            throw new RuntimeException("Error downloading Withdrawal Notice!");
        }
    }
}
